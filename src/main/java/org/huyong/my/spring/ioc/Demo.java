package org.huyong.my.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yonghu on 2020/5/14.
 */
public class Demo {
    public static void main(String args[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/huyong/my/spring/ioc/spring.xml");
        Object object = applicationContext.getBean("car");
        System.out.print(object.getClass());
    }
}
