package org.huyong.my.rtti.cglib;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yonghu on 2020/3/6.
 */
public class AppTest {
    @Test
    public void test(){
        Integer integer = new Integer(1);


        List list = new ArrayList<>();
        Map map = new HashMap<>();


        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
