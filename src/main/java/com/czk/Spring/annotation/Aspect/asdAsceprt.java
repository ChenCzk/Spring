package com.czk.Spring.annotation.Aspect;

import com.czk.Spring.POJO.Role;
import org.aspectj.lang.annotation.*;

/*
* 带参数的切面类
* */
@Aspect
public class asdAsceprt {
//        @Pointcut("execution(* com.czk.Spring.annotation.Myinterface.asdService.get(..))" + "&& args(role,i)")
//        public void print(Role role, int i){
//
//        }
//
//Role role, int i
    @Before("execution(* com.czk.Spring.annotation.Imp.asdServiceImpl.get(..))" + "&& args(role,i)")
    public void before(Role role, int i){
        System.out.println("before");
        System.out.println(role);
        System.out.println(i);
    }
    @After("execution(* com.czk.Spring.annotation.Imp.asdServiceImpl.get(..))")
    public void after(){
        System.out.println("after");

    }
    @AfterReturning("execution(* com.czk.Spring.annotation.Imp.asdServiceImpl.get(..))" )
    public void afterReturing(){
        System.out.println("afterReturing");

    }
    @AfterThrowing("execution(* com.czk.Spring.annotation.Myinterface.asdService.get(..))" )
    public void afterThrowing(){
        System.out.println("afterThrowing");

    }



}