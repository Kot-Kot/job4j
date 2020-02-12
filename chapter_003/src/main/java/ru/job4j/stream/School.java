package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, int low, int high) {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > low && student.getScore() < high
        ).collect(Collectors.toList());
        return result;
    }
    Map<String, Integer> studentMap(List<Student> students) {
        Map<String, Integer> result = students.stream().collect(
                Collectors.toMap(Student::getName, Student::getScore));
        return result;
    }

    public static void main(String[] args) {
        Student s1 = new Student("vasya", 90);
        Student s2 = new Student("kolya", 80);
        Student s3 = new Student("dima", 50);
        Student s4 = new Student("misha", 40);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        System.out.println(new School().studentMap(list).toString());

        
    }
}
