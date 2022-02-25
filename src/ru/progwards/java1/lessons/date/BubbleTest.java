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
                i3 = System.currentTimeMillis();
                if (a[j].compareTo(a[n]) < 0) {
                    i4 = System.currentTimeMillis();
                    Integer tmp = a[j];
                    i5 = System.currentTimeMillis();
                    a[j] = a[n];
                    i6 = System.currentTimeMillis();
                    a[j] = tmp;
                    i7 = System.currentTimeMillis();
                }
                i8 = System.currentTimeMillis();
            }
            i9 = System.currentTimeMillis();
        }
        i10 = System.currentTimeMillis();
        long t_all = i10 - i0; // all
        long t_fc = i9 -i1; // тело 1 цикла
        long t_sc = i8 -i2; // тело 2 цикла
        long t_next_j = i3 -i2; // next_j n = j + 1;
        long t_tmp = i5 -i4; // присвоение tmp = a[j]
        long t_aj = i6 -i5; // присвоение a[j] = a[n];
        long t_an = i7 -i6; // присвоение a[j] = tmp;
        System.out.println("all" + " || 100%" );
        System.out.println("for (int i = 0; i < a.length; i++)" + " || " + (double) t_fc/ (double) t_all * 100 +"%");
        /*System.out.println("int n = j + 1" + " || " + t_next_j/ t_all );
        System.out.println("for (int j = 0; j < a.length - i - 1; j++)" + " || " + t_fc/ t_all );
        System.out.println("for (int j = 0; j < a.length - i - 1; j++)" + " || " + t_fc/ t_all );
        System.out.println("for (int j = 0; j < a.length - i - 1; j++)" + " || " + t_fc/ t_all );
        System.out.println("for (int j = 0; j < a.length - i - 1; j++)" + " || " + t_fc/ t_all );
        System.out.println("for (int j = 0; j < a.length - i - 1; j++)" + " || " + t_fc/ t_all );
        System.out.println("for (int j = 0; j < a.length - i - 1; j++)" + " || " + t_fc/ t_all );

         */

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[COUNT];
        fill(a);
        bubbleSort(a);
    }

}
