package org.huyong.my.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yonghu on 2020/6/10.
 */
@SpringBootApplication
public class MySpringbootTomcatStarter {
    public static void main(String[] args) {
        Long time=System.currentTimeMillis();
        SpringApplication.run(MySpringbootTomcatStarter.class);
        System.out.println("===应用启动耗时："+(System.currentTimeMillis()-time)+"===");
    }

}
