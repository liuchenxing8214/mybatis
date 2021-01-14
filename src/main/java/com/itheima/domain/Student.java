package com.itheima.domain;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private int create;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", create=" + create +
                '}';
    }
}
