package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int count = 0;
        int leftCount = 0;
        int rightCount = 0;
        do {
            if (left.length == 0 && right.length == 0) {
                break;
            } else if (left.length > 0 && right.length > 0 && leftCount < left.length && rightCount < right.length) {
                if (left[leftCount] < right[rightCount]) {
                    rsl[count] = left[leftCount];
                    count++;
                    leftCount++;
                } else if (left[leftCount] > right[rightCount]) {
                    rsl[count] = right[rightCount];
                    count++;
                    rightCount++;
                } else {
                    rsl[count] = left[leftCount];
                    count++;
                    rsl[count] = right[rightCount];
                    count++;
                    leftCount++;
                    rightCount++;
                }

            } else if (left.length == 0 || leftCount >= left.length) {
                rsl[count] = right[rightCount];
                count++;
                rightCount++;
            } else if (right.length == 0 ||  rightCount >= right.length) {
                rsl[count] = left[leftCount];
                count++;
                leftCount++;
            }

        } while (leftCount < left.length || rightCount < right.length);

        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
