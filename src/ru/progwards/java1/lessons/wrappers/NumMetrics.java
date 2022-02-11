package ru.progwards.java1.lessons.wrappers;

public class NumMetrics {
    public static Integer sumDigits(Integer number) {
        Integer fd = number / 100;
        Integer sd = (number % 100) / 10;
        Integer td = number % 10;
        return fd + sd + td;
    }

    public static Integer mulDigits(Integer number) {
        Integer fd = number / 100;
        Integer sd = (number % 100) / 10;
        Integer td = number % 10;
        return fd * sd * td;
    }

    public static void main(String[] args) {
        /*
        Integer a = 165;
        System.out.println(sumDigits(a));
        System.out.println(mulDigits(a));
        */

    }
}
