package ru.progwards.java1.lessons.arrays1;

public class ArraySort {
    public static void sort(int[] a) {
        int tmp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] kishmish = {23, 66, 234, 86, 35, 968, 43, 0, 54, 86};
        sort(kishmish);
        for (int i : kishmish)
            System.out.print(i + " ");
        System.out.println();
    }
}
