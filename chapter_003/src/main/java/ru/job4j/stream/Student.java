package ru.job4j.stream;

import java.util.Set;

public class Student {
    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUnits() {
        return units;
    }

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
