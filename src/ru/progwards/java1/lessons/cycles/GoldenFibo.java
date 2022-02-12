package ru.progwards.java1.lessons.cycles;

public class GoldenFibo {
    public static int fiboNumber(int n) {
        int tmp;
        int fibo1 = 1, fibo2 = 1, i = 0;
        while (i++ < (n - 2)) {
            tmp = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = tmp;
        }
        return fibo2;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        boolean b1 = a == b && (double) a / c > 1.61703 && (double) a / c < 1.61903;
        boolean b2 = a == c && (double) a / b > 1.61703 && (double) a / b < 1.61903;
        boolean b3 = b == c && (double) b / a > 1.61703 && (double) b / a < 1.61903;
        return (b1 || b2 || b3);
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 15; i++)
            System.out.println(fiboNumber(i));

        int j = 6;
        int fiboPrev = 5;
        while (true) {
            // не смог понять зачем вложенный цикл, если есть функция по вычислению фибо
            // поэтому обошелся одним
            int c = fiboPrev;
            int a = fiboNumber(j);
            if (a >= 100)
                break;
            if (isGoldenTriangle(a, a, c))
                System.out.println(c + " " + a + " " + a);
            fiboPrev = a;
            j++;
        }
    }
}
