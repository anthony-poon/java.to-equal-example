package com.anthonypoon;

import com.anthonypoon.entity.Student;
import com.anthonypoon.lib.DataCollector;
import com.anthonypoon.lib.DataSource;

import java.util.List;

public class Main {
    /**
     * 1. Read a list of student from an unspecified data source, for example, a csv file.
     * 2. Index all the student so that it can be queried in O(1) time
     * 3. Query by classId and age
     */
    public static void main(String[] args) {
        List<Student> students = DataSource.read();
        DataCollector collector = new DataCollector();
        collector.addAll(students);

        Student result = collector.query(1, 20);
        System.out.println(result.getName() + " is a 20 years old student in class #1");
    }
}