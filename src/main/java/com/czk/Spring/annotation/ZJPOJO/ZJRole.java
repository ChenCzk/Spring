package com.czk.Spring.annotation.ZJPOJO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/*
* 注解注入属性
* */
@Component(value = "zjRole")
public class ZJRole {
    @Value("${id}")
    private int id;
    @Value("注解注入")
    private String name;
    @Value("bad")
    private String health;
    @Value("111")
    private String grade;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health='" + health + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public ZJRole() {
    }

    public ZJRole(int id, String name, String health, String grade) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
