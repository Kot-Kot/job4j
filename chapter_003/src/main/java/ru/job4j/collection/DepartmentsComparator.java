package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int result = 0;
        if (s1.length() < s2.length()) {
            result = -1;
        }
        return result;
    }
}
