package ru.job4j.calculator;
/**
 * Calculator Класс для вычисления арифм операций
 *
 * @author Eugene Shapoval (eshapoval@yandex.ru)
 * @version 1.0
 * @since 01.12.19
 */
public class Calculator {

    /**
     * add сложение двух чисел
     *
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + "+" + second + " = " + result);
    }
    /**
     * div деление двух чисел
     *
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first + "/" + second + " = " + result);
    }
    /**
     * multiply умножение двух чисел
     *
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + "*" + second + " = " + result);
    }
    /**
     * subtract вычитание двух чисел
     *
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void subtract(double first, double second) {
        double result =  first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

    /**
     * main вызов статических методов
     * @param args аргументы
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtract(10, 5);
    }

}
