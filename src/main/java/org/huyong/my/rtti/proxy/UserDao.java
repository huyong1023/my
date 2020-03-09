package org.huyong.my.rtti.proxy;

/**
 * Created by yonghu on 2020/3/6.
 */
public class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
