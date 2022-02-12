package ru.progwards.java1.lessons.compare;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c) {
        return (a + b > c && a + c > b && b + c > a);
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        return isTriangle(a, b, c) && (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a);
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        return isTriangle(a, b, c) && (a == b || a == c || b == c);
    }

    public static void main(String[] args) {
        /*
        int a=3;
        int b=3;
        int c=3;
        System.out.println(isTriangle(a,b,c));
        System.out.println(isRightTriangle(a,b,c));
        System.out.println(isIsoscelesTriangle(a,b,c));
        */

    }
}
