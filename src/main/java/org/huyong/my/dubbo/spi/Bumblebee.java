package org.huyong.my.dubbo.spi;

/**
 * Created by yonghu on 2020/5/29.
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
