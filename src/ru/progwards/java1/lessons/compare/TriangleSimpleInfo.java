package ru.progwards.java1.lessons.compare;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c) {
        //return Math.max(Math.max(a, b), c);
        if (a >= b && a >= c)
            return a;
        else if (b >= a && b >= c)
            return b;
        else
            return c;

    }

    public static int minSide(int a, int b, int c) {
        //return Math.min(Math.min(a, b), c);
        if (a <= b && a <= c)
            return a;
        else if (b <= a && b <= c)
            return b;
        else
            return c;

    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {
        return (a == b && a == c);
    }

    public static void main(String[] args) {
        /*
        int a=3;
        int b=3;
        int c=9;
        System.out.println(maxSide(a,b,c));
        System.out.println(minSide(a,b,c));
        System.out.println(isEquilateralTriangle(a,b,c));
        */

    }

}
