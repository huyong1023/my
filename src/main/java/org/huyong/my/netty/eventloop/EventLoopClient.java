package org.huyong.my.netty.eventloop;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

public class EventLoopClient {
    public static void main(String[] args) throws Exception{
        String abc="hello,world";
        //1、启动类
        Channel channel = (Channel) new Bootstrap()
                //2、添加 EventLoop
                .group(new NioEventLoopGroup())
                //3、选择客户端 channel 实现
                .channel(NioSocketChannel.class)
                //4、添加处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override //载链接建立后被调用
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        //编码，将字符串转换为 ByteBuf
                        nioSocketChannel.pipeline().addLast(new StringEncoder());
                    }
                })
                //5、连接到服务器
                .connect(new InetSocketAddress("localhost", 8080))
                .sync()//阻塞方法，直到建立连接
                .channel()
                .writeAndFlush(abc);
    }





}
