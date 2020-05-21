package org.huyong.my.spring.aop.proxyfactorybean;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by yonghu on 2020/5/16.
 */
public class MethodLoggerAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String name = method.getName();
        System.out.println("method name "+ name +" now is invoke");


    }
}
