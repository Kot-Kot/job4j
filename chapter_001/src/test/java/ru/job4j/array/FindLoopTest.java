package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = FindLoop.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas3Then2() {
        int[] input = new int[]{5, 10, 3};
        int value = 3;
        int result = FindLoop.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasNot13ThenNotFound() {
        int[] input = new int[]{5, 10, 3};
        int value = 13;
        int result = FindLoop.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind3() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOfDiapason(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenNotFind() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 100;
        int start = 0;
        int finish = 4;
        int result = FindLoop.indexOfDiapason(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind2() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 10;
        int start = 2;
        int finish = 2;
        int result = FindLoop.indexOfDiapason(input, value, start, finish);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort5() {
        int[] input = new int[]{3, 4, 1, 2, 5};
        int[] result = FindLoop.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort3() {
        int[] input = new int[]{3, 4, 1};
        int[] result = FindLoop.sort(input);
        int[] expect = new int[]{1, 3, 4};
        assertThat(result, is(expect));
    }
}