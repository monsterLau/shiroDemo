package com.example.shiroDemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class LoginAspect {
    @Pointcut("@annotation(com.example.shiroDemo.aspect.LoginAnnotation)")
    public void login() {
    }

    @Around("login()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        //目标类
        Class clazz = proceedingJoinPoint.getTarget().getClass();

        return proceedingJoinPoint;
    }
}
