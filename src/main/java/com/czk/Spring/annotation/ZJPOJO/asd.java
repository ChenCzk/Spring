package com.czk.Spring.annotation.ZJPOJO;

import org.springframework.beans.factory.annotation.Value;

public class asd {
    @Value("${id}")
    private int id;
    private String name;
    private String grade;
    private String health;

    public asd() {
    }

    public asd(String name, String grade, String health) {
        this.name = name;
        this.grade = grade;
        this.health = health;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}
