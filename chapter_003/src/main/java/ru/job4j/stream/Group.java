package ru.job4j.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(
                m -> Student.Holder(m.getName(), m.getUnits(0))
        ).collect( // собираем карту
                Collectors.groupingBy(t -> t.key, // определяем группировку
                        Collector.of(
                                HashSet::new, // аккумулятор.
                                (set, el) -> // как добавлять данные.
                                        (left, right) -> { left.addAll(right); return left; } // для агрегации.
                        )
                )
        );
    }

    public static void main(String[] args) {
        Student s1 = new Student("artem", new HashSet<>(Set.of("s1", "s2")));
        Student s2 = new Student("borya", new HashSet<>(Set.of("s1")));
        Student s3 = new Student("kolya", new HashSet<>(Set.of("s2", "s3")));
        Student s4 = new Student("misha", new HashSet<>(Set.of("s1", "s2", "s3")));
        List<Student> students = List.of(s1, s2, s3, s4);
        sections(students);
    }
}