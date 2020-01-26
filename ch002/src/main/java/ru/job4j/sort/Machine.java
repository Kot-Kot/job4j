package ru.job4j.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int delta = money - price;
        int[] rsl = new int[100];
        int size = 0;
        for (int coin : COINS) {
                while (delta - coin >= 0) {
                    if (delta - coin >= 0) {
                        rsl[size] = coin;
                        size++;
                        delta -= coin;
                    } else if (delta - coin < 0) {
                        break;
                    }
                }
        }
        return Arrays.copyOf(rsl, size);
    }

    

}