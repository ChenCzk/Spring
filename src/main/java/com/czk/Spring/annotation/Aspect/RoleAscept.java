package com.czk.Spring.annotation.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
/*
* 定义切面
* */
@Aspect
public class RoleAscept {
    @Pointcut("execution(* com.czk.Spring.annotation.Imp.RoleServiceImp.getRole(..))")
    public void print(){
    }


    @Before("print()")
    public void before(){
        System.out.println("before");
    }
    @After("print()")
    public void after(){
        System.out.println("after");
    }
    @AfterReturning("print()")
    public void afterReturing(){
        System.out.println("afterReturing");
    }
    @AfterThrowing("print()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    @Around("execution(* com.czk.Spring.annotation.Imp.RoleServiceImp.getRole(..))")
    public void around(ProceedingJoinPoint jp){
        System.out.println("around before");
        try {
            jp.proceed();
        }catch (Throwable e){
            System.out.println("around error");
        }
        System.out.println("around after");
    }
}
