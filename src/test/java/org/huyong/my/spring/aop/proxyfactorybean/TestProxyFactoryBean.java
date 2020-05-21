package org.huyong.my.spring.aop.proxyfactorybean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yonghu on 2020/5/16.
 */
public class TestProxyFactoryBean {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("proxy-factory-bean.xml");
        IBussinessService bussinessServiceImpl = applicationContext.getBean("methodProxy", IBussinessService.class);
        bussinessServiceImpl.bussiness();


    }
}
