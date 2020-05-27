package org.huyong.my.jvm.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonghu on 2020/5/27.
 */
public class HeapOOM {

    static int MB = 1024*1024;


    public static void main(String[] args ) {
        List<Object> list = new ArrayList<Object>();

        for (int i = 0; i < 10000; i++){
            ByteBuffer bb = ByteBuffer.allocate(MB);
            list.add(bb);
            System.out.println("分派第"+(i+1)+" MB");
        }
    }

}
