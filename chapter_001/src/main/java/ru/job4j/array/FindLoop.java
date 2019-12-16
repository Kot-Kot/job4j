package ru.job4j.array;

public class FindLoop {
    public static int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public static int indexOfDiapason(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = start; i <= finish; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public static int[] sort(int[] data) {
        int minElem;
        int minElemIndex;
        int tmpElem;
        for (int i = 0; i < data.length; i++) {
            minElem = MinDiapason.findMin(data, i, data.length - 1);
            minElemIndex = FindLoop.indexOfDiapason(data, minElem, i, data.length - 1);
            tmpElem = data[i];
            data[i] = data[minElemIndex];
            data[minElemIndex] = tmpElem;
        }

        return data;
    }
}
