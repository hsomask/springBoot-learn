package com.springbootdemo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
/*
 1.将yml配置文件中配置的每一个值映射到这个组件中
 2.@ConfigurationProperties告诉springboot 将本类中的所有属性与配置文件中的配置相关联
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private  String lastName;
    private  int age;
    private  boolean boss;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object>lists;
    private  Dog dog;

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isBoss() {
        return boss;
    }

    public Date getBirth() {
        return birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
