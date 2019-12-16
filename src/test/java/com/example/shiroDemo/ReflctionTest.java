package com.example.shiroDemo;

import com.example.shiroDemo.entity.Person;
import org.apache.ibatis.javassist.compiler.ast.FieldDecl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//@SpringBootTest
public class ReflctionTest {
    @Test
    public void test() {
        Person person = new Person("name", 11);
        System.out.println(person.toString());
    }

    @Test
    public void test2() throws Exception {
        //通过反射创建person类
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, Integer.class);
        Object o = constructor.newInstance("Tom", 10);
        Person p = (Person) o;
        System.out.println(o.toString());

        //通过反射调用指定属性，方法
        Field age = clazz.getDeclaredField("age");
        age.set(p, 12);
        System.out.println(o.toString());

        //调方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);


        //通过反射，调用私有结构，方法，属性，构造器等
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        //设置可以
        cons1.setAccessible(true);

        Object jerry = cons1.newInstance("Jerry");
//        Person pJerry = (Person) jerry;
//         Field name =
        System.out.println(jerry.toString());

        //反射调用私有属性
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(jerry, "JerryChange");
        System.out.println(jerry.toString());

        //反射调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //invoke 相当于调用，jerry.showNation("China")
        Object china = showNation.invoke(jerry, "China");
        System.out.println(china);
    }


    /**
     * 获取实例的方式
     */
    @Test
    public void test3() throws Exception {
        //方法1
        Class<Person> personClass1 = Person.class;
        Constructor constructor = personClass1.getConstructor(String.class, Integer.class);
        Object tom = constructor.newInstance("Tom", 10);
        Field name = personClass1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(tom, "testChange");
        System.out.println(tom.toString());
        //方法2
        Person person = new Person();
        Class<? extends Person> personClass2 = person.getClass();
        System.out.println(personClass2);
        //方法3
        Class<?> personClass3 = Class.forName("com.example.shiroDemo.entity.Person");
        System.out.println(personClass3);
        //方法4 classLoader
        ClassLoader classLoader = ReflctionTest.class.getClassLoader();
        Class<?> personClass4 = classLoader.loadClass("com.example.shiroDemo.entity.Person");
        System.out.println(personClass4);
    }

    @Test
    public void getField() throws Exception {
        Class clazz = Person.class;

        Object o = clazz.newInstance();
        //设置当前运行时类的某个属性的值
        Field id = clazz.getDeclaredField("id");
        Field name = clazz.getDeclaredField("name");
        id.setAccessible(true);
        name.setAccessible(true);
        id.set(o, 10L);
        name.set(o, "Tom");
        System.out.println(o.toString());

        //获取当前运行时类某个属性的值
        Object oId = id.get(o);
        Object oName = name.get(o);
        System.out.println(oId);
        System.out.println(oId.getClass());
        System.out.println(oName);
        System.out.println(oName.getClass());
    }

    /**
     * 操作运行时类的方法
     */
    @Test
    public void getMethod() throws Exception {
        Class clazz = Person.class;
        Object o = clazz.newInstance();
        Method show = clazz.getDeclaredMethod("showNation", String.class);
        show.setAccessible(true);
        show.invoke(o, "change show!");
    }
}
