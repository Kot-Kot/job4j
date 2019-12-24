package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void case1() {
        double result =  new Triangle(new Point(0, 0), new Point(0, 5), new Point(5, 0)).area();
        assertThat(result, is(12.5));
    }
    @Test
    public void case2() {
        double result =  new Triangle(new Point(0, 0), new Point(5, 5), new Point(0, 0)).area();
        assertThat(result, is(-1d));
    }
}