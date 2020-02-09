package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, int low, int high) {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > low && student.getScore() < high
        ).collect(Collectors.toList());
        return result;
    }

    public static void main(String[] args) {
        Student s1 = new Student(90);
        Student s2 = new Student(80);
        Student s3 = new Student(50);
        Student s4 = new Student(40);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        System.out.println(new School().collect(list, 70, 100).toString());


    }
}
