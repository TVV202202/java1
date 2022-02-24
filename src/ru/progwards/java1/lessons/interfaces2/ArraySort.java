package ru.progwards.java1.lessons.interfaces2;

public class ArraySort {
    public static void sort(CompareWeight[] a) {
        CompareWeight tmp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].getWeight() > a[j].getWeight()) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

}
