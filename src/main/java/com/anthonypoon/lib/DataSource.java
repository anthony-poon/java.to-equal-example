package com.anthonypoon.lib;

import com.anthonypoon.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Student> read() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 1, 18, "John Doe"));
        students.add(new Student(1, 2, 18, "Mary Leung"));
        students.add(new Student(1, 1, 20, "Peter Pan"));
        students.add(new Student(1, 1, 22, "Eric Sze"));
        return students;
    }
}
