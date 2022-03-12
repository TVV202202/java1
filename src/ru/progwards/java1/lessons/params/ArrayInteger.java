package ru.progwards.java1.lessons.params;

import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;


    /*
    public ArrayInteger(int n){
        int i = 0, k = n;
        while (n != 0){
            //digits[i] = (byte) (n % 10);
            n /= 10;
            i++;
        }
        digits = new byte[i];
        i = 0;
        n = k;
        while (n != 0){
            digits[i] = (byte) (n % 10);
            n /= 10;
            i++;
        }
    }

     */
    public ArrayInteger(int n) {
        digits = new byte[n];
    }

    void fromString(String value) {
        char[] ch = value.toCharArray();
        digits = new byte[ch.length];
        for (int i = 0; i < ch.length / 2 + 1; i++) {
            digits[i] = (byte) (ch[ch.length - 1 - i] - '0');
            digits[ch.length - 1 - i] = (byte) (ch[i] - '0');
        }
    }

    public String toString() {
        String[] str = new String[digits.length];
        for (int i = 0; i < digits.length; i++) {
            str[i] = String.valueOf(digits[digits.length - 1 - i]);
        }
        return String.join("", str);
    }

    boolean add(ArrayInteger num) {
        if (digits.length < num.digits.length) {
            digits = new byte[]{0};
            return false;
        } else {
            byte k = 0;
            for (int i = 0; i < digits.length; i++) {
                digits[i] = (byte) (digits[i] + num.digits[i] + k);
                if (digits[i] > 9) {
                    if (i != digits.length - 1) {
                        digits[i] -= 10;
                        k = 1;
                    } else {
                        digits = new byte[]{0};
                        return false;
                    }
                } else {
                    k = 0;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayInteger num = new ArrayInteger(10);
        System.out.println(num.toString());
        num.fromString("10");
        System.out.println(Arrays.toString(num.digits));
        System.out.println(num);
        ArrayInteger num3 = new ArrayInteger(4);
        num3.fromString("90");
        System.out.println(num3);
        num.add(num3);
        System.out.println(num);


    }
}
