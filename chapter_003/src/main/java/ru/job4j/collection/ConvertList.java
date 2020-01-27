package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] row : list) {
            for (int cell : row) {
                rsl.add(cell);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<int[]> names = new ArrayList<>();
        names.add(new int[] {1, 2});
        names.add(new int[] {3, 4, 5});
        for (int i : convert(names)) {
                System.out.println(i);
        }
        }
    }