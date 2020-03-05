package org.huyong.my.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by yonghu on 2019/11/14.
 */
public class MyNIOClient extends Thread {

    public void run(){
        try (SocketChannel socketChannel = SocketChannel.open();){

            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888));

            while(!socketChannel.finishConnect() ){

            }

            send(socketChannel);


        }catch (IOException e){
            e.printStackTrace();

        }
    }



    public void send (SocketChannel socketChannel ){
        try {
            ByteBuffer writerBuf = ByteBuffer.allocate(48);

            ByteBuffer readBuf = ByteBuffer.allocate(48);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";

            while(!(s = bufferedReader.readLine()).equals("")) {
                writerBuf.clear();
                writerBuf.put(s.getBytes());
                writerBuf.flip();
                socketChannel.write(writerBuf);

                socketChannel.read(readBuf);
                readBuf.flip();

                byte[] data = readBuf.array();
                String msg = new String(data).trim();
                System.out.println("res：" + msg);
                // make buffer ready for writing
                readBuf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) {
        MyNIOClient client = new MyNIOClient();
        client.run();
    }

}
