package com.example.shiroDemo;

import com.example.shiroDemo.entity.Person;
import org.junit.jupiter.api.Test;

/**
 * 通过反射创建运行时类对象
 */
public class NewReflection {
    @Test
    public void test() throws Exception {
        Class clazz = Person.class;
        //newInstance() -> 调用运行时类无参构造器
        Object o = clazz.newInstance();
        Person person = (Person) o;
        System.out.println(person);
    }
}
