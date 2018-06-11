package org.huyong.my.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yonghu on 2018/6/11.
 */
public class NIO2Server extends Thread {
    public void run() {
        try {


            AsynchronousServerSocketChannel serverSock = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSock.accept(serverSock, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {


                // 为异步操作指定 CompletionHandler 回调函数
                @Override
                public void completed(AsynchronousSocketChannel sockChannel, AsynchronousServerSocketChannel serverSock) {
                    serverSock.accept(serverSock, this);
                    // 另外一个 write（sock，CompletionHandler{}）
                    try {
                        sayHelloWorld(sockChannel, Charset.defaultCharset().encode("Hello World!"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(AsynchronousSocketChannel server, ByteBuffer buffer) throws IOException {
        try  {
            server.write(buffer);
        }finally {
            try {
                //关闭处理完的socket，并重新调用accept等待新的连接
                server.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        NIO2Server server = new NIO2Server();
        server.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), 8888)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        }
    }
}
