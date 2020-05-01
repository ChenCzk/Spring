package com.czk.Spring.annotation.ZJPOJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "zjPerson")
public class ZJPerson {
    @Autowired
    private ZJRole zjRole;

    @Override
    public String toString() {
        return "ZJPerson{" +
                "zjRole=" + zjRole +
                '}';
    }

    public ZJRole getZjRole() {
        return zjRole;
    }

    public void setZjRole(ZJRole zjRole) {
        this.zjRole = zjRole;
    }
}
