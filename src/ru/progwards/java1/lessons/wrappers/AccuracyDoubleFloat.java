package ru.progwards.java1.lessons.wrappers;

public class AccuracyDoubleFloat {
    static Double R = 6371.2;
    static Double PI = 3.14;

    public static Double volumeBallDouble(Double radius) {
        return 4.0 / 3.0 * PI * radius * radius * radius;
    }

    public static Float volumeBallFloat(Float radius) {
        float pi = PI.floatValue();
        return 4.0f / 3.0f * pi * radius * radius * radius;
    }

    public static Double calculateAccuracy(Double radius) {
        return volumeBallDouble(radius) - volumeBallFloat(radius.floatValue());
    }

    public static void main(String[] args) {
        /*
        Double a = 1.0;
        System.out.println(volumeBallDouble(a));
        System.out.println(volumeBallFloat(a.floatValue()));
        System.out.println(calculateAccuracy(R));
        */
    }
}
