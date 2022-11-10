package org.huyong.my.netty.codec;

// HttpServerHandler

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * 说明：
 * 1.SimpleChannelInboundHandler是ChannelInboundHandlerAdapter
 * 2.HttpObject客户端和服务器端相互通讯的数据被封装成HttpObject
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    // channelRead0 读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        // 判断httpObject是不是httprequest请求
        if (httpObject instanceof HttpRequest) {

            // 不同的浏览器和相同浏览器每次刷新   都会是不一样的hashCoed
            System.out.println("pipeline hashcode=" + channelHandlerContext.pipeline().hashCode() + "HttpServerhandler hashCOde=" + this.hashCode());

            System.out.println("httpObject 类型=" + httpObject.getClass());
            System.out.println("客户端地址=" + channelHandlerContext.channel().remoteAddress());

            // 获取HttpRequest
            HttpRequest httpRequest = (HttpRequest) httpObject;
            // 获取uri
            URI uri = new URI(httpRequest.getUri());
            if ("/favicon.ico".equals(uri.getPath())){
                System.out.println("被拦截的请求，不做处理");
                return;
            }

            // 回复信息给浏览器
            ByteBuf content = Unpooled.copiedBuffer("hello, 我是服务器!", CharsetUtil.UTF_8);
            // 构造一个http的响应，即httpResponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // 将构建好的response返回
            channelHandlerContext.writeAndFlush(response);
        }
    }
}

