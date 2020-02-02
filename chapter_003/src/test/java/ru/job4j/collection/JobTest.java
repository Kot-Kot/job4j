package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    @Ignore
    public void sortByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobByName().thenComparing(new JobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B task", 0),
                new Job("A task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    @Ignore
    public void sortByName() {
        List<Job> actual = new ArrayList<>();
        actual.add(new Job("b task", 2));
        actual.add(new Job("c task", 1));
        actual.add(new Job("a task", 3));
        Collections.sort(actual, new JobByName());
        assertEquals(actual.get(0), new Job("a task", 3));
    }
    @Test
    @Ignore
    public void sortByNameReverse() {
        List<Job> actual = new ArrayList<>();
        actual.add(new Job("b task", 2));
        actual.add(new Job("c task", 1));
        actual.add(new Job("a task", 3));
        Collections.sort(actual, new JobByName().reversed());
        assertEquals(actual.get(0), new Job("c task", 1));
    }
    @Test
    @Ignore
    public void sortByPriority() {
        List<Job> actual = new ArrayList<>();
        actual.add(new Job("b task", 2));
        actual.add(new Job("c task", 1));
        actual.add(new Job("a task", 3));
        Collections.sort(actual, new JobByPriority());
        assertEquals(actual.get(0), new Job("c task", 1));
    }
    @Test
    @Ignore
    public void sortByPriorityReverse() {
        List<Job> actual = new ArrayList<>();
        actual.add(new Job("b task", 2));
        actual.add(new Job("c task", 1));
        actual.add(new Job("a task", 3));
        Collections.sort(actual, new JobByPriority().reversed());
        assertEquals(actual.get(0), new Job("a task", 3));
    }

}