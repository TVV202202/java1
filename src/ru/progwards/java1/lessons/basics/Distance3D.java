package ru.progwards.java1.lessons.basics;

public class Distance3D {
    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        // AB = √((xb - xa)2 + (yb - ya)2 + (zb - za)2)
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

    public static void main(String[] args) {

    }
}
