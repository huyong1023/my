package org.huyong.my.netty.eventloop;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.TimeUnit;

public class TestEventLoop {
    public static void main(String[] args) {
        //1、创建事件循环组
        EventLoopGroup group = new NioEventLoopGroup(2); //能处理 io事件、普通任务、定时任务，如果不传参数，默认有8个线程
        //EventLoopGroup eventExecutors = new DefaultEventLoopGroup();//能处理 普通任务、定时任务，如果不传参数，默认有8个线程
        //2、获取下一个事件循环对象
        System.out.println(group.next());//第一个线程
        System.out.println(group.next());//第二个线程
        System.out.println(group.next());//第一个线程
        //3、执行普通任务
        /*
        group.next().submit(() -> {
            try {
                Thread.sleep(1000);
                log.info("普通任务");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        */
        //4、执行定时任务
        //参数一：执行的任务
        //参数二：等待多久后后执行
        //参数三：每隔多久执行一次
        //参数四：时间单位
        group.next().scheduleAtFixedRate(() -> {

        },3,5, TimeUnit.SECONDS);

    }
}
