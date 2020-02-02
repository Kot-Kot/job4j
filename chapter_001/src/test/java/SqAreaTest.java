package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square() {
        int in1 = 6;
        int in2 = 2;
        double expected = 2;
        double out = SqArea.square(in1, in2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void square1() {
        int in1 = 20;
        int in2 = 1;
        double expected = 25;
        double out = SqArea.square(in1, in2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void square2() {
        int in1 = 0;
        int in2 = 0;
        double expected = 0;
        double out = SqArea.square(in1, in2);
        Assert.assertEquals(expected, out, 0.01);
    }



}
