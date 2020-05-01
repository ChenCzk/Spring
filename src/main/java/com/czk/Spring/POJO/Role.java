package com.czk.Spring.POJO;

public class Role {
    private int id;
    private String name;
    private String health;
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

    public Role() {
    }

    public Role(int id, String name, String health, String grade) {
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
