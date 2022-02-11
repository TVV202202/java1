package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number) {
        int fd = number / 100;
        int sd = (number % 100) / 10;
        int td = number % 10;
        return td * 100 + sd * 10 + fd;
    }

    public static void main(String[] args) {

    }
}
