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
        /**
         *  使用Foreach时对集合的结构进行修改会出现异常:
         *
         * 　　上面我们说了实现了Iterable接口的类就可以通过Foreach遍历，那是因为foreach要依赖于Iterable接口返回的Iterator对象，所以从本质上来讲，Foreach其实就是在使用迭代器，在使用foreach遍历时对集合的结构进行修改，和在使用Iterator遍历时对集合结构进行修改本质上是一样的。所以同样的也会抛出异常，执行快速失败机制。
         *
         * 　　foreach是JDK1.5新增加的一个循环结构，foreach的出现是为了简化我们遍历集合的行为。
         *
         *  for循环与迭代器的对比:
         *
         * 　　* 效率上各有各的优势:
         *
         * 　　　　> ArrayList对随机访问比较快，而for循环中使用的get()方法，采用的即是随机访问的方法，因此在ArrayList里for循环快。
         *
         * 　　　　> LinkedList则是顺序访问比较快，Iterator中的next()方法采用的是顺序访问方法，因此在LinkedList里使用Iterator较快。
         *
         * 　　　　> 主要还是要依据集合的数据结构不同的判断。
         */
//        for (Person p : people) {
//            if (p.getName().equals("a")) {
//                people.remove(p);
//            }
//        }
//        System.out.println(people.size());
    }
}
