package org.example.mini.spring.bean.factory.test;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author yelihu
 * @time 2023/4/17
 */
public class UserService {

    private String userId;

    private UserDao userDao;

    public String getUserNameById() {
        return userDao.getUserNameById(userId);
    }
}
