package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void Turn1() {
        Turn turn = new Turn();
        int[] input = new int[] {1, 2, 3};
        int[] result = turn.back(input);
        int[] expect = new int[] {3, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void Turn2() {
        Turn turn = new Turn();
        int[] input = new int[] {1, 2, 3, 4};
        int[] result = turn.back(input);
        int[] expect = new int[] {4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}
