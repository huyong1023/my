package org.huyong.my.spring.aop.proxyfactorybean;

/**
 * Created by yonghu on 2020/5/16.
 */
public class BussinessServiceImpl implements IBussinessService {
    @Override
    public void bussiness() {
        System.out.println("I do someting");
    }
}
