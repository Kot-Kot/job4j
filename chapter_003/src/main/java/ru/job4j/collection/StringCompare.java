package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = -100;
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();
        int minLength = Math.min(leftArr.length, rightArr.length);
        for (int i = 0; i < minLength; i++) {
            if (leftArr[i] > rightArr[i]) {
                result = 1;
                break;
            } else if (leftArr[i] < rightArr[i]) {
                result = -1;
                break;
            } else {
                result = 0;
            }
        }
        if (result == 0 && leftArr.length != rightArr.length) {
            result = leftArr.length > rightArr.length ? 1 : -1;
        }
        return result;
    }
}