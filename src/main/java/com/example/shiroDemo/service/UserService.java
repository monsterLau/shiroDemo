package com.example.shiroDemo.service;

import com.example.shiroDemo.entity.User;
import com.example.shiroDemo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User queryByUserName(String userName) {
        return userDao.queryByUserName(userName);
    }

    public void insertUser(String userName, String password) {
        userDao.insertUser(userName, password);
    }
}
