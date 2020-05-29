package org.huyong.my.dubbo.mock.service.impl;

import org.huyong.my.dubbo.entity.User;
import org.huyong.my.dubbo.mock.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonghu on 2020/5/27.
 */
public class UserServiceImpl implements UserService{
    private static List<User> USER_LIST = new ArrayList<User>();


    static {
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setAddress("address" + i);
            u.setId(i);
            u.setName("name" + i);
            USER_LIST.add(u);
        }
    }


    public void addUser(User u) {
        USER_LIST.add(u);
        System.out.println("total:" + USER_LIST.size());

    }


    public User getUserById(int id) {
        for (int i = 0; i < USER_LIST.size(); i++) {
            if (USER_LIST.get(i).getId() == id) {
                return USER_LIST.get(i);
            }
        }
        return null;
    }
}
