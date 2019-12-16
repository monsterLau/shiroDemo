package com.example.shiroDemo.entity;

import com.example.shiroDemo.aspect.MyAnnotation;
import com.example.shiroDemo.mapper.MyInterface;

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private Long id;
    private String name;
    public Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person(char gender, double wight, Long id, String name, Integer age) {
        super(gender, wight);
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "Person(String name)")
    private Person(String name) {
        this.name = name;
    }

    @MyAnnotation(value = "show()")
    public void show() {
        System.out.println("i am a person");
    }

    @MyAnnotation(value = "showNation()")
    private String showNation(String nation) {
        System.out.println("my nation is " + nation);
        return nation;
    }

    public Person() {
        System.out.println("person()");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("I am a person");
    }

    public String display(String interest) {
        return interest;
    }
}
