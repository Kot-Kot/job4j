package ru.job4j.funcinterface;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CountFunctionTest {
    @Test
    public void linearFunction() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void squareFunction() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(1, 3, x -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void logFunction() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(1, 3, x -> Math.log(x));
        List<Double> expected = Arrays.asList(Math.log(1D), Math.log(2D), Math.log(3D));
        assertThat(result, is(expected));
    }
}
