package ru.progwards.java1.lessons.basics;

public class Astronomy {
    static final double PI = 3.14;

    public static Double sphereSquare(Double r) {
        // S = 4πR2
        return 4 * PI * r * r;
    }

    public static Double earthSquare() {
        double r = 6371.2;
        return sphereSquare(r);
    }

    public static Double mercurySquare() {
        double r = 2439.7;
        return sphereSquare(r);
    }

    public static Double jupiterSquare() {
        double r = 71492;
        return sphereSquare(r);
    }

    public static Double earthVsMercury() {
        return earthSquare() / mercurySquare();
    }

    public static Double earthVsJupiter() {
        return earthSquare() / jupiterSquare();
    }

    public static void main(String[] args) {

    }
}
