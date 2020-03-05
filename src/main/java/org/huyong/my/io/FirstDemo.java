package org.huyong.my.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yonghu on 2019/11/13.
 */
public class FirstDemo {

    public static void main(String args[]) {
        try (RandomAccessFile aFile = new RandomAccessFile("/Users/yonghu/Desktop/nio-data.txt", "rw")) {
            FileChannel inChannel = aFile.getChannel();

            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);

            //read into buffer
            int bytesRead = inChannel.read(buf);



            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                // make buffer ready for read
                buf.flip();

                while (buf.hasRemaining()) {
                    //read a byte at a time
                    System.out.print( (char) buf.get());
                }

                // make buffer ready for writing
                buf.clear();


                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
