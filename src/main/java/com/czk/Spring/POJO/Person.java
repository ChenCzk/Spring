package com.czk.Spring.POJO;

public class Person {
    private int id;
    private String name;
    private String sex;
    private Role role;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", role=" + role +
                '}';
    }

    public Person() {
    }

    public Person(int id, String name, String sex, com.czk.Spring.POJO.Role role) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.role = role;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
