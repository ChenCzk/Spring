package com.czk.Spring.annotation.Imp;

import com.czk.Spring.POJO.Role;
import com.czk.Spring.annotation.Myinterface.asdService;
import org.springframework.stereotype.Component;

/*
* 带参数的切面类Role role, int i
* */
@Component
public class asdServiceImpl implements asdService {

    public void get(Role role, int i) {
        System.out.println(role);
        System.out.println(i);
    }
}
