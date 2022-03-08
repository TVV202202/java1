package ru.progwards.java1.lessons.params;

import java.math.BigDecimal;

public class Decimal {
    long integer;
    long fractional;
    Decimal(long integer, long fractional){
        this.integer =integer;
        this.fractional =fractional;
    }
    Decimal(double num){
        integer = (long) num;
        String n = Double.toString(num);
        //String n1;
        if (n.indexOf(".") != -1)
            fractional = Long.parseLong(n.substring(n.indexOf(".")+1));
        else
            fractional = 0;
    }
    @Override
    public String toString(){
        return integer + "." + fractional;
    }
    public double toDouble(){
        return Double.parseDouble(integer+"." + fractional);
    }
    public Decimal add(Decimal num){
        Decimal d = new Decimal(this.toDouble() + num.toDouble());
        System.out.println(this.toDouble());
        System.out.println(num.toDouble());
        return new Decimal(this.toDouble() + num.toDouble());
    }
    Decimal sub(Decimal num){
        return new Decimal(this.toDouble() - num.toDouble());
    }
    public static void main(String[] args) {
        Decimal dec = new Decimal(2.111);
        Decimal d2 = new Decimal(1.1);
        //System.out.println(dec.fractional);
        //System.out.println(dec.toDouble());
        System.out.println(dec.add(d2));
        System.out.println(d2.sub(dec));

    }
}
