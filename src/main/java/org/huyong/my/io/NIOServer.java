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
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yonghu on 2018/6/11.
 */
public class NIOServer extends Thread {
    public void run() {
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocket = ServerSocketChannel.open();) {// 创建 Selector 和 Channel
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

                    if(key.isReadable()){
                        sayHelloWorld((SocketChannel) key.channel());
                    }


                    // 生产系统中一般会额外进行就绪状态检查
                    //sayHelloWorld((ServerSocketChannel) key.channel());
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(SocketChannel server) throws IOException {

        //创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1);
        int read = server.read(buffer);
        if(read > 0){
            System.out.print("test");
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("服务端收到信息：" + msg);
            //回写数据
            ByteBuffer outBuffer = ByteBuffer.wrap("服务端收到了你的消息".getBytes());
            server.write(outBuffer);
        }else {
            System.out.println("客户端关闭");

        }


    }


    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.start();
        //try (Socket client = new Socket(InetAddress.getLocalHost(), 8888)) {
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //bufferedReader.lines().forEach(s -> System.out.println(s));
        //    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        //    String s = "";
        //    while(!(s = bufferedReader.readLine()).equals("")) {
         //       bufferedWriter.write(s);
         //   }
       // }
    }
}
