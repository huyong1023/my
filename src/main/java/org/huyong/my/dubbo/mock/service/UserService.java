package org.huyong.my.dubbo.mock.service;

import org.huyong.my.dubbo.entity.User;

/**
 * Created by yonghu on 2020/5/27.
 */
public interface UserService {
    public void addUser(User u);



    public User getUserById(int id);
}
