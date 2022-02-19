package ru.progwards.java1.lessons.arrays1;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;

    public Eratosthenes(int N) {
        sieve = new boolean[N + 1];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        sieve[0] = sieve[1] = false;
        for (int i = 2; i <= (int) Math.sqrt(sieve.length); i++) {
            if (sieve[i]) {
                for (int j = i * i; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }

    public boolean isSimple(int n) {
        return sieve[n];
    }

    public static void main(String[] args) {
        Eratosthenes erat = new Eratosthenes(100);
        int n = 7;
        if (n>0 && n<=100)
            System.out.println(erat.isSimple(n));
        else
            System.out.println("n вне диапазона");
    }
}
