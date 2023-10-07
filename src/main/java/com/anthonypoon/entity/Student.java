package com.anthonypoon.entity;

public class Student {
    private final int id;
    private final int classId;
    private final int age;
    private final String name;
    public Student(int id, int classId, int age, String name) {
        this.id = id;
        this.classId = classId;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
