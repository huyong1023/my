package org.huyong.my.jvm.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by yonghu on 2020/5/27.
 */

/**
 *
 */
public class ConstantPoolOOM {

    public static void main(String[] args){
        List<Object> list = new ArrayList<>();


        for (int i = 0; i < 1000000; i++) {
            list.add(UUID.randomUUID().toString().intern());
            System.out.println("list size :" +  i);
        }
    }



}




