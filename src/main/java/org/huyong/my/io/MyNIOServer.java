package org.huyong.my.io;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yonghu on 2019/11/13.
 */
public class MyNIOServer extends Thread {

    private Selector selector;

    public void run() {
        try {// 创建 Selector 和 Channel

            selector = Selector.open();
            ServerSocketChannel serverSocket = ServerSocketChannel.open();

            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.configureBlocking(false);
            // 注册到 Selector，并说明关注点
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            //serverSocket.register(selector, SelectionKey.OP_ACCEPT | SelectionKey.OP_READ);
            while (true) {
                selector.select();// 阻塞等待就绪的 Channel，这是关键点之一
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();

                    if(key.isAcceptable()){
                        handlerAccept(key);
                    } else if(key.isReadable()){
                        sayHelloWorld(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        //获得和客户端连接的通道
        SocketChannel channel = serverSocketChannel.accept();
        //设置成非阻塞
        channel.configureBlocking(false);
        //在这里可以给客户端发送信息
        System.out.println("新的客户端连接");
        //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限
        channel.register(this.selector,SelectionKey.OP_READ);
    }



    private void sayHelloWorld(SelectionKey key) throws IOException {
        //服务器可以读取消息：获取事件发生的socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        //创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = 0;
        try {
            read = channel.read(buffer);
        } catch (IOException e){
            System.out.println("客户端关闭");
            key.cancel();
        }
        if(read > 0){
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("服务端收到信息：" + msg);
            //回写数据
            ByteBuffer outBuffer = ByteBuffer.wrap("服务端收到了你的消息".getBytes());
            channel.write(outBuffer);
        }else {
            System.out.println("客户端关闭");
            key.cancel();
        }
    }




    public static void main(String[] args) throws IOException {
        MyNIOServer server = new MyNIOServer();
        server.start();


        /**
         try (Socket client = new Socket(InetAddress.getLocalHost(), 8888)) {
         //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
         //bufferedReader.lines().forEach(s -> System.out.println(s));
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
         String s = "";
         while(!(s = bufferedReader.readLine()).equals("")) {

         bufferedWriter.write(s);
         bufferedWriter.flush();
         }
         }

         */
    }

}