package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void max1() {

        int result = SqMax.max(1, 2, 4, 5);
        assertThat(result, is(5));
    }

    @Test
    public void max2() {

        int result = SqMax.max(10, 9, 8, 7);
        assertThat(result, is(10));
    }

    @Test
    public void max3() {

        int result = SqMax.max(10, 100, 1000, 20);
        assertThat(result, is(1000));
    }

    @Test
    public void max4() {

        int result = SqMax.max(10, 100, 10, 20);
        assertThat(result, is(100));
    }
}
