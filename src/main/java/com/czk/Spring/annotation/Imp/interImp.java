package com.czk.Spring.annotation.Imp;

import com.czk.Spring.annotation.Myinterface.RoleService;
import com.czk.Spring.annotation.Myinterface.inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class interImp implements inter {
    @Autowired
   private RoleService roleService;

    public void get() {
        System.out.println(roleService.getRole());
    }
}
