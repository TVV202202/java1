package ru.progwards.java1.lessons.date;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class BubbleTest {
    public static final int COUNT = 100000;

    public static void fill(Integer[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < COUNT; i++) {
            int n;
            do {
                n = ThreadLocalRandom.current().nextInt();
            } while (map.containsKey(n));
            a[i] = n;
            map.put(n, n);
        }
    }

    public static void bubbleSort(Integer[] a) {
        long i0=0, i1=0, i2=0, i3=0, i4=0, i5=0, i6=0, i7=0, i8=0, i9=0, i10 = 0;
        i0= System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            i1 = System.currentTimeMillis();
            for (int j = 0; j < a.length - i - 1; j++) {
                i2 = System.currentTimeMillis();
                int n = j + 1;

                if (a[j].compareTo(a[n]) < 0) {
                    i3 = System.currentTimeMillis();
                    Integer tmp = a[j];
                    a[j] = a[n];
                    a[j] = tmp;
                    i4 += System.currentTimeMillis() - i3;
                }
                i8 += System.currentTimeMillis() - i2;
            }
            i9 += (System.currentTimeMillis()-i1);
        }
        i10 = System.currentTimeMillis();
        double t_all = (double) (i10 - i0); // all
        double t_fc = (double) i9; // тело 1 цикла
        double t_sc = (double) i8; // тело 2 цикла
        //long t_next_j = i3 - i2; // next_j n = j + 1;
        double t_if= (double) i4; // if (a[j].compareTo(a[n]) < 0)

        System.out.println("all" + " || 100% - " + t_all);
        System.out.println("for (int i = 0; i < a.length; i++)" + " || " +  t_fc / t_all * 100 + "%");
        System.out.println("for (int j = 0; j < a.length - i - 1; j++)" + " || " +  t_sc / t_all * 100 + "%");
        System.out.println("fif (a[j].compareTo(a[n]) < 0)" + " || " +  t_if/ t_all * 100 + "%");

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[COUNT];
        fill(a);
        bubbleSort(a);
    }

}
