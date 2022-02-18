package ru.progwards.java1.lessons.arrays1;

public class Eratosthenes {
    private boolean[] sieve;

    public Eratosthenes(int N) {
        sieve = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            sieve[i] = true;
        }
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
        sift();
        return sieve[n];
    }

    public static void main(String[] args) {
        Eratosthenes erat = new Eratosthenes(100);
        System.out.println(erat.isSimple(1));
    }
}
