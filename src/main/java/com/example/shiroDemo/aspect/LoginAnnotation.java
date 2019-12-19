package com.example.shiroDemo.aspect;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LoginAnnotation {
    String getParam();

    String setParam();
}
