package com.example.shiroDemo;

import com.example.shiroDemo.entity.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {
    /**
     * 获取运行时方法
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        Object o = clazz.newInstance();
        //getDeclaredMethods() -> 获取当前运行时类的所有方法
        //getMethods() -> 获取当前时类及其父类的public方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getAnnotations();
            System.out.println(method.getName());
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
                System.out.println();
            }
        }

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            Annotation[] annotations = constructor.getAnnotations();
            for (Annotation annotationa : annotations) {
                System.out.println(annotationa);
            }
        }

    }

}
