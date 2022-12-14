package org.huyong.my.thread;


import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        FutureTask futureTask1=new FutureTask(new FThread2());
        ExecutorService threadpool = Executors.newFixedThreadPool(3);
        //futureTask1.run();
        //Thread t = new Thread(futureTask1);
        //t.start();
        threadpool.submit(futureTask1);
        //TimeUnit.MILLISECONDS.sleep(1000l);
        System.out.println("获取返回值1: " + futureTask1.get());



        CompletableFuture future2 = CompletableFuture.supplyAsync(()->{
            System.out.println("hello");
            return null;
        });

        CompletableFuture future3 = CompletableFuture.runAsync(() -> {
            System.out.println("hello");

        });
    }
}


class FThread1 implements Runnable{
    @Override
    public void run() {

    }
}


class FThread2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        System.out.println("calld方法执行了1");
        return "call方法返回值1";
    }
}
