package com.example.shiroDemo.mapper;

import com.example.shiroDemo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User queryByUserName(@Param("userName") String userName);

    void insertUser(@Param("userName") String userName, @Param("password") String password);
}
