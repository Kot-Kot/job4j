package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
       public int compare(String left, String right) {
        int len1 = left.length();
        int len2 = right.length();
        int lim = Math.min(len1, len2);
        char[] v1 = left.toCharArray();
        char[] v2 = right.toCharArray();
        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
    public static void main(String[] args) {
        System.out.println("a".compareTo("aaa"));
        System.out.println("a".compareTo("d"));
        System.out.println(new StringCompare().compare("a", "aaa"));
        System.out.println(new StringCompare().compare("a", "d"));
    }
}