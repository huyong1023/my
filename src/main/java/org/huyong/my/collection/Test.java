package org.huyong.my.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String args[]){
        Map<String, String> map = new HashMap();
        map.put("1", "1");

        Map<String, String> cMap = new ConcurrentHashMap<>();


        ReentrantLock lock = new ReentrantLock();
        lock.lock();


    }
}
