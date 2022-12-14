package org.huyong.my.netty.codec;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class ServerHandlerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //向管道加入处理器

        //得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 加入一个netty提供的HttpServerCodec Codec = [coder - decoder]
        // HttpServerCodec: 是Netty提供的基于http的编码解码器
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());

        // 增加一个自定义Handler
        pipeline.addLast("MyHttpServerHandler", new HttpServerHandler());
    }
}
