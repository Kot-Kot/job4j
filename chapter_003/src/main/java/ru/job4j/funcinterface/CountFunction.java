package ru.job4j.funcinterface;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CountFunction {
    //BiFunction<Double, Double, List<Double>> linear = (a, b) -> {return a * b;};

    //public interface LinearFunction() {
        //double calculate ( double x);
    //}
        List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = null;
        for (int i = start; i <= end; i++) {
            result.add(func.apply((double) i));
        }
        return result;

    }
    public static void main(String[] args) {
        CountFunction cf = new CountFunction();
        List<Double> result = cf.diapason(1, 8, x -> 2 * x + 1);
        System.out.println(result);
    }
}
