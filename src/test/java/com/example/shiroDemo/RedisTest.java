package com.example.shiroDemo;

import com.example.shiroDemo.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void redisTest() {
        redisUtil.set("hello", "world");
        Object hello = redisUtil.get("hello");
        String world = (String) hello;
        System.out.println(world);
    }
}
