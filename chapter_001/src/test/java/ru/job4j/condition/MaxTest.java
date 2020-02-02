package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To2Then2() {
        int result = Max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax10To2Then10() {
        int result = Max.max(10, 2);
        assertThat(result, is(10));
    }

    @Test
    public void whenMax1To2To3Then3() {
        int result = Max.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax2To2To2Then2() {
        int result = Max.max(2, 2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax10To2To1Then10() {
        int result = Max.max(10, 2, 1);
        assertThat(result, is(10));
    }

    @Test
    public void whenMax1To2To3To4Then4() {
        int result = Max.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenMax2To4To2To1Then4() {
        int result = Max.max(2, 4, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenMax100To2To1To99Then10() {
        int result = Max.max(100, 2, 1, 99);
        assertThat(result, is(100));
    }

}
