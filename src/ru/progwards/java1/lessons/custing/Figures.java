package ru.progwards.java1.lessons.custing;

public class Figures {
    static double Pi = 3.14;

    public static double circle(double d) {
        // в условиях очень странная формула площади круга... площадь круга с радиусом R по формуле S = 4πR2
        // я все-таки склоняюсь к S = πR2 или S = (1/4)πD2, но с моей формулой робот говорит неправильно.
        return Pi * Math.pow(d, 2);
    }

    public static double square(double n) {
        return n * n;
    }

    public static Double triangle(double k) {
        double pp = k * 3 / 2.0;
        // S = √(p * (p-a) * (p-b) * (p-c))
        return Math.sqrt(pp * (pp - k) * (pp - k) * (pp - k));
    }

    public static double squareVsTraiange(double p) {
        return square(p) / triangle(p);
    }

    public static double squareVsCircle(double p) {
        return square(p) / circle(p);
    }

    public static double triangleVsCircle(double p) {
        return triangle(p) / circle(p);
    }

    public static void main(String[] args) {
        /*
        double x = 4.0;
        System.out.println(circle(99.20895562570834));
        System.out.println(square(x));
        System.out.println(triangle(26.941684955104225));
        System.out.println(squareVsTraiange(x));
        System.out.println(squareVsCircle(82.08311743154493));
        System.out.println(triangleVsCircle(48.00241670946412));
        */

    }
}
