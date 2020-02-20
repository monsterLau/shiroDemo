package com.example.shiroDemo.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.shiroDemo.utils.RedisUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.Map;

public class aaa {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");

        //=====================testString======================
        redisUtil.set("name", "how2java");
        System.out.println(redisUtil.get("name"));
        redisUtil.del("name");
        System.out.println(redisUtil.get("name"));

        //=====================testNumber======================
        long incr = redisUtil.incr("number", 1);
        System.out.println(incr);
        incr = redisUtil.incr("number", 1);
        System.out.println(incr);

        //=====================testMap======================
        Map<String, Object> map = new HashMap<>();
        map.put("name", "meepo");
        map.put("pwd", "password");
        redisUtil.hmset("user", map);
        System.out.println(redisUtil.hget("user", "name"));

        Person p = new Person();
        p.setId(1L);
        p.setName("1");
        p.setAge(11);
        redisUtil.set("person", p);
        Object o = redisUtil.get("person");
        String pStr = JSON.toJSONString(o);
        Person p2 = JSON.parseObject(pStr, Person.class);
        System.out.println(p2 instanceof Person);
    }
}
