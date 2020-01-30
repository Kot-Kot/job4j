package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortItemByName implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) {
        return i1.getName().compareTo(i2.getName());
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("zoo"),
                new Item("apricot"),
                new Item("cat"),
                new Item("ball")
        );


        Collections.sort(items, new SortItemByName().reversed());

        System.out.println(items);
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}
