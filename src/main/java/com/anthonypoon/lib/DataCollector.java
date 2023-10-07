package com.anthonypoon.lib;

import com.anthonypoon.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DataCollector {
    private final Map<DataIndex, Student> indexes = new HashMap<>();

    /**
     * We want to index the student by classId and age, thus we need DataIndex class to be used as key
     */
    public void addAll(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            DataIndex index = new DataIndex(student);
            indexes.put(index, student);
        }
    }

    /**
     * We want to query student by classId and age, throw an error if not found
     * First we create an index using the constructor, then check against the HashMap
     */
    public Student query(int classId, int age) {
        DataIndex index = new DataIndex(classId, age);
        if (!indexes.containsKey(index)) {
            throw new RuntimeException("Student not found");
        }
        return indexes.get(index);
    }

    private static class DataIndex {
        private final int classId;
        private final int age;

        private DataIndex(int classId, int age) {
            this.classId = classId;
            this.age = age;
        }
        private DataIndex(Student student) {
            this.classId = student.getClassId();
            this.age = student.getAge();
        }

        /**
         * We need the equal method here. Without it, new DataIndex(1, 20) != new DataIndex(1, 20)
         * When indexes.containsKey(index) method is called, this method will be invoked
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataIndex dataIndex = (DataIndex) o;
            return classId == dataIndex.classId && age == dataIndex.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(classId, age);
        }
    }
}
