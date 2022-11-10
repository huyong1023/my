package org.huyong.my.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class MessageCodec extends MessageToMessageCodec<ByteBuf, Message> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, List<Object> list) throws Exception {
        ByteBuf byteBuf = channelHandlerContext.alloc().buffer();
        // 1、 4 字节的魔数
        byteBuf.writeBytes(new byte[]{1, 2, 3, 4});
        // 2、 1 字节的版本
        byteBuf.writeByte(1);
        // 3、 1字节的序列化方式 jdk 0 ，json 1
        byteBuf.writeByte(0);
        // 4、 1字节的指令类型
        byteBuf.writeByte(message.getMessageType());
        // 5、 设置请求序号 4个字节
        byteBuf.writeInt(4);
        // 6、 为了补齐为16个字节，填充1个字节的数据
        byteBuf.writeByte(0xff);

        // 序列化msg
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(message);
        byte[] bytes = bos.toByteArray();

        // 获得并设置正文长度 长度用4个字节标识
        byteBuf.writeInt(bytes.length);
        // 设置消息正文
        byteBuf.writeBytes(bytes);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        // 获取魔数
        int magic = byteBuf.readInt();
        // 获取版本号
        byte version = byteBuf.readByte();
        // 获得序列化方式
        byte seqType = byteBuf.readByte();
        // 获得指令类型
        byte messageType = byteBuf.readByte();
        // 获得请求序号
        int sequenceId = byteBuf.readInt();
        // 移除补齐字节
        byteBuf.readByte();
        // 获得正文长度
        int length = byteBuf.readInt();
        // 获得正文
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes, 0, length);
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Message message = (Message) ois.readObject();
        // 将信息放入List中，传递给下一个handler
        list.add(message);

        // 打印获得的信息正文
        System.out.println("===========魔数===========");
        System.out.println(magic);
        System.out.println("===========版本号===========");
        System.out.println(version);
        System.out.println("===========序列化方法===========");
        System.out.println(seqType);
        System.out.println("===========指令类型===========");
        System.out.println(messageType);
        System.out.println("===========请求序号===========");
        System.out.println(sequenceId);
        System.out.println("===========正文长度===========");
        System.out.println(length);
        System.out.println("===========正文===========");
        System.out.println(message);
    }
}
