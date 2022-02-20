package ru.progwards.java1.lessons.arrays2;

import java.util.Arrays;

public class IntArrays {
    public static String toString(int[] a) {
        if (a.length == 0)
            return "";
        String res = "[";
        for (int i = 0; i < a.length - 1; i++) {
            res += a[i] + ", ";
        }
        res += a[a.length - 1] + "]";
        return res;
    }

    public static boolean equals1(int[] a1, int[] a2) {
        // пришлось написать простейшую сортировку пузырьком, чтобы отсортировать массивы
        // и потом их сравнить. Больше ничего в голову не пришло :(
        if (a1.length != a2.length)
            return false;
        bubleSort(a1);
        bubleSort(a2);
        for (int i = 0; i < a1.length; i++) {
            System.out.println(i + "  " + a1[i] + "   " + a2[i]);
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }

    public static void bubleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public static boolean equals2(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(toString(a));
        int[] a1 = {1, 2, 3, 1, 4, 7, 6};
        int[] a2 = {3, 2, 1, 5, 7, 4, 1};
        System.out.println(equals1(a1, a2));
        System.out.println(equals2(a1, a2));

    }
}
