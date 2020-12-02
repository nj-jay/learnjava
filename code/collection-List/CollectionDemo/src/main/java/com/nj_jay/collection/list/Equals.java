package com.nj_jay.collection.list;

import java.util.*;

public class Equals {

    public static void main(String[] args) {

        List<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("nj"));

        Student s = new Student("nj");

        boolean c = arrayList.contains(s);

        System.out.println(c);

    }



}
