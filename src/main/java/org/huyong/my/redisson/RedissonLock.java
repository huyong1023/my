package org.huyong.my.redisson;

import org.junit.Test;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.io.Serializable;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class RedissonLock {



    public void test(){
        DelayQueue queue = new DelayQueue();
    }

    @Test
    public void testLock() throws InterruptedException {
        Config config = new Config();



        RedissonClient redisson = Redisson.create();

        redisson.getSet("hello2").add(2);
        redisson.getSet("hello2").add(2);

       // redisson.getSortedSet("hello").add(1);

        //redisson.getSortedSet("hello").add(1);

        while (true){
            Thread.sleep(1000);
        }

    }


    @Test
    public void testScoredSortedSet() throws InterruptedException {
        Config config = new Config();

        RedissonClient redisson = Redisson.create();

        RScoredSortedSet<SomeObject> set = redisson.getScoredSortedSet("simple");

        set.add(0.13, new SomeObject("field1Value", "field2Value"));
        set.add(0.33, new SomeObject("field1Value", "field2Value"));
        set.addAsync(0.251, new SomeObject("field3Value", "field4Value"));
        set.add(0.302, new SomeObject("field5Value", "field6Value"));



        int index = set.rank(new SomeObject("field5Value", "field6Value")); // 获取元素在集合中的位置
        Double score = set.getScore(new SomeObject("field5Value", "field6Value")); // 获取元素的评分

        while (true){
            Thread.sleep(1000);
        }
    }


    @Test
    public void testDelayed() throws InterruptedException {
        Config config = new Config();

        RedissonClient redisson = Redisson.create();
        RBlockingQueue blockingFairQueue = redisson.getBlockingQueue("delay_queue_call");
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(blockingFairQueue);
    // 10秒钟以后将消息发送到指定队列
        delayedQueue.offer("msg1", 30, TimeUnit.SECONDS);
        delayedQueue.offer("msg1", 40, TimeUnit.SECONDS);
    // 一分钟以后将消息发送到指定队列
        delayedQueue.offer("msg2", 1, TimeUnit.MINUTES);

        while (true){
            Thread.sleep(1000);
        }


    }


}

class SomeObject implements Serializable {
    private String key;
    private String val;
    SomeObject(String key, String val){
        this.key = key;
        this.val = val;
    }

    SomeObject(){}

}
