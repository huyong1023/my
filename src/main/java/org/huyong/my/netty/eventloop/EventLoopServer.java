package org.huyong.my.netty.eventloop;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.huyong.my.netty.codec.ServerHandlerInitializer;

public class EventLoopServer {
    public static void main(String[] args) {
        EventLoopGroup group = new DefaultEventLoopGroup();//默认为8个线程
        new ServerBootstrap()
                //线程组一（new NioEventLoopGroup()）：只负责 ServerSocketChannel 上的 accept 事件。没必要设置有多少个线程，不设置默认8个。
                //线程组二（new NioEventLoopGroup(2)）：只负责 SocketChannel 上的读写，可以设置有多少个线程，不设置默认为8个。
                .group(new NioEventLoopGroup(), new NioEventLoopGroup(2))
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerHandlerInitializer())
                .bind(8080);
    }
}
