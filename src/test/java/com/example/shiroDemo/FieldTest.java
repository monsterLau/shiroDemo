package com.example.shiroDemo;

import com.example.shiroDemo.entity.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的所有属性
 */
public class FieldTest {

    @Test
    public void test1() {
        Class clazz = Person.class;
        //获取属性结构
        //getFields()：获取当前运行时类及父类的 public 属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.toString());
        }

        //getDeclaredFields()：获取当前运行时类的 所有 属性 , 不包括父类属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    /**
     * 权限修饰符 数据类型 变量名
     */
    @Test
    public void test2() {
        Class clazz = Person.class;

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.toString()+"\t");

            //获取权限修饰符
            int modifiers = field.getModifiers();
            System.out.println(Modifier.toString(modifiers) + "\t");

            //获取数据类型
            Class<?> type = field.getType();
            System.out.println(type.getName() + "\t");

            //获取变量名
            String fieldName = field.getName();
            System.out.println(fieldName + "\t");
        }
    }
}
