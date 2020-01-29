package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class SortItemByNameTest {
    @Test
    public void sort() {
        List<Item> actual = Arrays.asList(
                new Item("Zzz"),
                new Item("Aaa"),
                new Item("Ccc"),
                new Item("Вbb")
        );
        List<Item> expected = Arrays.asList(
                new Item("Aaa"),
                new Item("Bbb"),
                new Item("Ccc"),
                new Item("Zzz")
        );
        Collections.sort(actual, new SortItemByName());

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void sortReverse() {
        List<Item> actual = Arrays.asList(
                new Item("Aaa"),
                new Item("Ccc"),
                new Item("Вbb")
        );
        System.out.println(Arrays.toString(actual.toArray()));

        List<Item> expected = Arrays.asList(
                new Item("Ccc"),
                new Item("Bbb"),
                new Item("Aaa")
        );
        Collections.sort(actual, new SortItemByName().reversed());

        Assert.assertEquals(expected, actual);
    }
}
