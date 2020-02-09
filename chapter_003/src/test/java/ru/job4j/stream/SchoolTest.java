package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.search.Person;
import ru.job4j.search.PhoneDictionary;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void when70to100() {
        Student s1 = new Student(90);
        Student s2 = new Student(80);
        Student s3 = new Student(50);
        Student s4 = new Student(40);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        List<Student> actual = new School().collect(list, 70, 100);
        List<Student> expected = new ArrayList<>();
        expected.add(s1);
        expected.add(s2);

        assertEquals(expected, actual);
    }

    @Test
    public void when50to70() {
        Student s1 = new Student(90);
        Student s2 = new Student(80);
        Student s3 = new Student(50);
        Student s4 = new Student(40);
        Student s5 = new Student(60);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        List<Student> actual = new School().collect(list, 50, 70);
        List<Student> expected = new ArrayList<>();
        expected.add(s5);

        assertEquals(expected, actual);
    }
    @Test
    public void when0to50() {
        Student s1 = new Student(90);
        Student s2 = new Student(80);
        Student s3 = new Student(50);
        Student s5 = new Student(60);
        Student s6 = new Student(20);
        Student s7 = new Student(10);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s5);
        list.add(s6);
        list.add(s7);

        List<Student> actual = new School().collect(list, 0, 50);
        List<Student> expected = new ArrayList<>();
        expected.add(s6);
        expected.add(s7);


        assertEquals(expected, actual);
    }
}
