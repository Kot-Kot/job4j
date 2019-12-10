package ru.job4j.condition;

public class Point {

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y2, 2));
    }

    public static void main(String[] args) {
        double result1 = distance(0, 0, 2, 0);
        double result2 = distance(0, 0, 5, 5);
        double result3 = distance(0, 0, -10, -1);
        System.out.println("result (0, 0) to (2, 0) " + result1);
        System.out.println("result (0, 0) to (5, 5) " + result2);
        System.out.println("result (0, 0) to (-10, -1) " + result3);
    }

}
