package org.huyong.my.juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


    public static void main(String args[]){
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
