package ru.job4j.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    List<Student> collect(List<Student> students, int low, int high) {
        List<Student> result = students.stream().filter(
                student -> student.getScore() > low && student.getScore() < high
        ).collect(Collectors.toList());
        return result;
    }
    Map<String, Integer> studentMap(List<Student> students) {
        Map<String, Integer> result = students.stream()
                .distinct()
                .flatMap(Stream::ofNullable)
                .collect(
                Collectors.toMap(Student::getName, Student::getScore));
        return result;
    }
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .distinct()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(v -> v.getScore() > bound)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Student s0 = null;
        Student s1 = new Student("vasya", 10);
        Student s2 = new Student("kolya", 20);
        Student s3 = new Student("dima", 90);
        Student s4 = new Student("sasha", 50);
        Student s5 = new Student("misha", 95);
        List<Student> list = new ArrayList<>();
        list.add(s0);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        System.out.println(new School().studentMap(list).toString());
        System.out.println(new School().levelOf(list, 49).toString());



    }
}
