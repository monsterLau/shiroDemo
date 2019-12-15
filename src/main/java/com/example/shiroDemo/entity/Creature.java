package com.example.shiroDemo.entity;

import java.io.Serializable;

public class Creature<T> implements Serializable {

    private char gender;
    public double wight;

    private void breath() {
        System.out.println("creature is breathing");
    }

    private void eat() {
        System.out.println("creature is eating");
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getWight() {
        return wight;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    public Creature(char gender, double wight) {
        this.gender = gender;
        this.wight = wight;
    }

    public Creature() {
    }

    @Override
    public String toString() {
        return "Creature{" +
                "gender=" + gender +
                ", wight=" + wight +
                '}';
    }
}
