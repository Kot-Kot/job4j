package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start == "") {
                    tmp.add(el);
                } else {
                    tmp.add(start + "/" + el);
                }
                start += el;

            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
    }

    public static void main(String[] args) {

        List<String> input1 = Arrays.asList("k1/sk1");
        List<String> input2 = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input1);
        System.out.println(result);
    }
}