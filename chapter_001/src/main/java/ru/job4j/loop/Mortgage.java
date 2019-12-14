package ru.job4j.loop;

public class Mortgage {
    public int year(double amount, double salary, double percent) {
        int year = 0;
        while (amount * (1 + percent * 0.01) > salary) {
            amount *= 1 + percent * 0.01;
            amount -= salary;
            year++;
        }
        return year + 1;
    }
}
