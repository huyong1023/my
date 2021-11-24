package org.huyong.my.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixThreadPoolDemo {
    public static class MyTask implements Runnable{

        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread Name:" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        int size =5;
        //下篇说下阿里技术规范插件对这个的提示问题
//        ExecutorService executorService = new ThreadPoolExecutor(size,size,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
//        ExecutorService executorService2 = new ThreadPoolExecutor(size,size,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);

        ExecutorService es = Executors.newFixedThreadPool(size);
        for (int i = 0; i < 10 ; i++) {
            Future future = es.submit(myTask);
        }

    }


}
