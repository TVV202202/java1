package ru.progwards.java1.lessons.params;

import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;
    public ArrayInteger(){

    }
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

    void fromString(String value){
        char[] ch = value.toCharArray();
        digits = new byte[ch.length];
        for (int i =0; i < ch.length / 2 + 1; i++){
            digits[i] = (byte) (ch[ch.length - 1 - i] - '0');
            digits[ch.length - 1 - i] = (byte) (ch[i] - '0');
        }
    }

    public String toString(){
        String[] str = new String[digits.length];
        for (int i =0; i < digits.length; i++){
            str[i] = String.valueOf(digits[digits.length - 1 - i]);
        }
        return String.join("", str);
    }
    boolean add(ArrayInteger num){
        if (digits.length < num.digits.length) {
            digits = new byte[]{0};
            return false;
        }
        else{
            byte k = 0;
            for (int i=0; i < digits.length; i++){
                byte tmp = (byte) (digits[i] + num.digits[i] + k);
                if (tmp < 10){
                    digits[i] = tmp;
                    k = 0;
                }
                else{
                    if (i != digits.length - 1){
                        digits[i] = (byte) (tmp % 10);
                        k = 1;
                    }
                    else{
                        digits = new byte[]{0};
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayInteger num = new ArrayInteger(159);
        System.out.println(Arrays.toString(num.digits));
        ArrayInteger num2 = new ArrayInteger();
        num2.fromString("12345");
        System.out.println(Arrays.toString(num2.digits));
        System.out.println(num);
        ArrayInteger num3 = new ArrayInteger(911);
        System.out.println(num3);
        num.add(num3);
        System.out.println(num);
    }
}
