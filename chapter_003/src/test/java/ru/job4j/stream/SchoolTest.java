package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void when70to100() {
        Student1 s1 = new Student1("vasya", 90);
        Student1 s2 = new Student1("kolya",80);
        Student1 s3 = new Student1("dima",50);
        Student1 s4 = new Student1("misha",40);
        List<Student1> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        List<Student1> actual = new School().collect(list, 70, 100);
        List<Student1> expected = new ArrayList<>();
        expected.add(s1);
        expected.add(s2);

        assertEquals(expected, actual);
    }

    @Test
    public void when50to70() {
        Student1 s1 = new Student1("vasya", 90);
        Student1 s2 = new Student1("kolya",80);
        Student1 s3 = new Student1("dima",50);
        Student1 s4 = new Student1("misha",40);
        Student1 s5 = new Student1("rona",60);
        List<Student1> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        List<Student1> actual = new School().collect(list, 50, 70);
        List<Student1> expected = new ArrayList<>();
        expected.add(s5);

        assertEquals(expected, actual);
    }
    @Test
    public void when0to50() {
        Student1 s1 = new Student1("vasya", 90);
        Student1 s2 = new Student1("kolya",80);
        Student1 s3 = new Student1("dima",50);
        Student1 s5 = new Student1("misha",60);
        Student1 s6 = new Student1("sasha",20);
        Student1 s7 = new Student1("dasha",10);
        List<Student1> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s5);
        list.add(s6);
        list.add(s7);

        List<Student1> actual = new School().collect(list, 0, 50);
        List<Student1> expected = new ArrayList<>();
        expected.add(s6);
        expected.add(s7);


        assertEquals(expected, actual);
    }
}
