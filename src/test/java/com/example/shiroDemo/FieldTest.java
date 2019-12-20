package com.example.shiroDemo;

import com.example.shiroDemo.entity.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
            System.out.println(field.toString() + "\t");

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

    @Test
    public void test3() {
        Person p1 = new Person();
        p1.setName("a");
        Person p2 = new Person();
        p2.setName("b");
        Person p3 = new Person();
        p3.setName("a");
        Person p4 = new Person();
        p4.setName("c");

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);

//        Iterator<Person> personIterator = people.iterator();
//        while (personIterator.hasNext()) {
//            Person p = personIterator.next();
//            if (p.getName().equals("a")) {
//                System.out.println(p.toString());
//                personIterator.remove();
//            }
//        }
        //foreach 里面不要进行remove add操作
        for (Person p : people) {
            if (p.getName().equals("a")) {
                people.remove(p);
            }
        }
        System.out.println(people.size());
    }
}
