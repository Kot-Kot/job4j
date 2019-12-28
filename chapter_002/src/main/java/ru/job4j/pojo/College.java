package ru.job4j.pojo;

import java.time.LocalDate;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иванов И. И.");
        student.setGroup("БМ-30");
        student.setEnrollDate(LocalDate.now());

        System.out.println("ФИО : " + student.getName());
        System.out.println("Группа : " + student.getGroup());
        System.out.println("Дата поступления : " + student.getEnrollDate());
    }
}
