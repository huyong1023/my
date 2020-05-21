package org.huyong.my.spring.ioc.constructorarg;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yonghu on 2020/5/18.
 */
public class DemoTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/huyong/my/spring/ioc/constructorarg/spring.xml");
        Object object = applicationContext.getBean("student");
        System.out.print(object.getClass());
    }
}
