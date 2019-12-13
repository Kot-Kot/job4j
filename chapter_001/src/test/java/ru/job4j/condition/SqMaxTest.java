package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void Max1() {

        int result = SqMax.max(1, 2, 4, 5);
        assertThat(result, is(5));
    }

    @Test
    public void Max2() {

        int result = SqMax.max(10, 9, 8, 7);
        assertThat(result, is(10));
    }

    @Test
    public void Max3() {

        int result = SqMax.max(10, 100, 1000, 20);
        assertThat(result, is(1000));
    }

    @Test
    public void Max4() {

        int result = SqMax.max(10, 100, 10, 20);
        assertThat(result, is(100));
    }
}
