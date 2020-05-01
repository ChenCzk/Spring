package com.czk.Spring.annotation.Imp;

import com.czk.Spring.annotation.ZJPOJO.ZJRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImp2 implements com.czk.Spring.annotation.Myinterface.RoleService {
    @Autowired
    ZJRole zjRole = null;
    public ZJRole getRole() {
        System.out.println("roleService2");
        return zjRole;
    }
}
