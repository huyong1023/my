package org.huyong.my.dubbo.mock.service.impl;

import org.huyong.my.dubbo.entity.User;
import org.huyong.my.dubbo.mock.service.UserService;

/**
 * Created by yonghu on 2020/5/27.
 */
public class UserServiceMock implements UserService {


    @Override
    public void addUser(User u) {

    }

    @Override
    public User getUserById(int id) {
        return null;
    }
}
