package ru.progwards.java1.lessons.cycles;

public class NumbersRange {
    public static long sumNumbers(int start, int finish){
        int res=0;
        for (;start<=finish; start++){
            res += start;
        }
        return res;
    }
    public static long sumOdd(int start, int finish){
        int res=0;
        for (;start<=finish; start++){
            if (start % 2 == 0)
                res += start;
        }
        return res;
    }
    public static long sumEvenIdx(int start, int finish){
        int res=0;
        for (;start<=finish; start++){
            res += start++;
        }
        return res;

    }
    public static void main(String[] args) {
        System.out.println(sumNumbers(20,24));
        System.out.println(sumOdd(20,24));
        System.out.println(sumEvenIdx(20,24));

    }
}
