package org.huyong.my.jvm.oom;

import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonghu on 2020/5/27.
 */
public class DirectMemoryOOM {
    static int ONE_MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedIOException, InterruptedException {
        List<ByteBuffer> list = new ArrayList<ByteBuffer>();

        for (int i =0; i < ONE_MB; i++) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(ONE_MB*128);
            list.add(buffer);
            Thread.sleep(1000);
            System.out.println("allocate" + (i+1) + "block 128M");
        }
    }
}
