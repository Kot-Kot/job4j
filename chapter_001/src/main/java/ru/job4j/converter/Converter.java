package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(200);
        int dollar = rubleToDollar(200);
        int ruble1 = euroToRuble(5);
        int ruble2 = dollarToRuble(5);
        System.out.println("200 rubles are " + euro + " euro.");
        System.out.println("200 rubles are " + dollar + " dollar.");
        System.out.println("5 euros are " + ruble1 + " ruble.");
        System.out.println("5 dollars are " + ruble2 + " ruble.");
        int in1 = 140;
        int expected1 = 2;
        int out1 = rubleToEuro(in1);
        boolean passed1 = expected1 == out1;
        System.out.println("200 rubles are 2 euro. Test result : " + passed1);
        int in2 = 140;
        int expected2 = 2;
        int out2 = rubleToDollar(in1);
        boolean passed2 = expected1 == out1;
        System.out.println("200 rubles are 3 dollar. Test result : " + passed2);
        int in3 = 5;
        int expected3 = 350;
        int out3 = euroToRuble(in1);
        boolean passed3 = expected1 == out1;
        System.out.println("5 euros are 350 rubles. Test result : " + passed3);
        int in4 = 5;
        int expected4 = 300;
        int out4 = dollarToRuble(in1);
        boolean passed4 = expected1 == out1;
        System.out.println("5 dollars are 300 rubles. Test result : " + passed4);


    }

}
