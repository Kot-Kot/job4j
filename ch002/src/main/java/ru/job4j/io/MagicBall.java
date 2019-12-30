package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        String result;
        System.out.println("Я великий Оракул. Что ты хочешь узнать?");
        while (!new Scanner(System.in).nextLine().equals("Выход")) {
            int answer = new Random().nextInt(3);
            if (answer == 0) {
                result = "Да";
            } else if (answer == 1) {
                result = "Нет";
            } else {
                result = "Может быть";
            }
            System.out.println(result);
        }


    }
}
