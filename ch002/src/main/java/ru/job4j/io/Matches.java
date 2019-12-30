package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matchesQuantity = 11;
        int count = 1;
        String result;
        while (matchesQuantity > 0) {
            if (count % 2 != 0) {
                System.out.println("Ход 1го игрока");
            } else {
                System.out.println("Ход 2го игрока");
            }
            int playerMatches = Integer.valueOf(new Scanner(System.in).nextLine());
            matchesQuantity -= playerMatches;
            System.out.println("На столе осталось спичек: " + matchesQuantity);
            count++;
        }


    }
}
