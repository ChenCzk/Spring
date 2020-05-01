package com.czk.Spring.POJO;

import java.util.*;

public class MyCollection {
    private List<String> list ;
    private Map<String,String > map;
    private Properties properties;
    private Set<String> set;
    private String[] str;

    public MyCollection() {
    }

    public MyCollection(List<String> list, Map<String, String> map, Properties properties, Set<String> set, String[] str) {
        this.list = list;
        this.map = map;
        this.properties = properties;
        this.set = set;
        this.str = str;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                ", set=" + set +
                ", str=" + Arrays.toString(str) +
                '}';
    }
}
