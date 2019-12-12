package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }
    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(10, 4, 2);
        assertThat(result, is(10));
    }

    @Test
    public void whenThirsMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 5);
        assertThat(result, is(5));
    }

    @Test
    public void Case1() {
        MultiMax check = new MultiMax();
        int result = check.max(10, 10, 100);
        assertThat(result, is(100));
    }

    @Test
    public void Case2() {
        MultiMax check = new MultiMax();
        int result = check.max(10, 10, 10);
        assertThat(result, is(10));
    }

    @Test
    public void Case3() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 10, 1);
        assertThat(result, is(10));
    }

}