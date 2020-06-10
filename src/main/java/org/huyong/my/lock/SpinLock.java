package org.huyong.my.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by yonghu on 2020/6/10.
 */
public class SpinLock {

    private AtomicReference<Thread> cas = new AtomicReference<Thread>();

    public void lock() {
        Thread current = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);

    }

}