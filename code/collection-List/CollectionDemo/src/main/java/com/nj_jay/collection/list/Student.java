package com.nj_jay.collection.list;

import java.util.Objects;

public class Student {

    String name;

    public Student(String name) {

        this.name = name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

}
