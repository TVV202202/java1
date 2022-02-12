package ru.progwards.java1.lessons.classes1;

public class ComplexNum {
    int a;
    int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        if (b > 0)
            return a + "+" + b + "i";
        else if (b < 0)
            return a + "" + b + "i";
        else
            return Integer.toString(a);
    }

    public ComplexNum add(ComplexNum num) {
        return new ComplexNum(this.a + num.a, this.b + num.b);
    }

    public ComplexNum sub(ComplexNum num) {
        return new ComplexNum(this.a - num.a, this.b - num.b);
    }

    public ComplexNum mul(ComplexNum num) {
        // (a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
        return new ComplexNum(this.a * num.a - this.b * num.b, this.b * num.a + this.a * num.b);
    }

    public ComplexNum div(ComplexNum num) {
        // (a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
        // не понимаю, если условие, что a и b должны быть целые, то получается целочисленное деление комплексных чисел?
        int a = (this.a * num.a + this.b * num.b) / (num.a * num.a + num.b * num.b);
        int b = (this.b * num.a - this.a * num.b) / (num.a * num.a + num.b * num.b);
        return new ComplexNum(a, b);
    }

    public static void main(String[] args) {
        ComplexNum x = new ComplexNum(7, 4);
        ComplexNum y = new ComplexNum(4, 6);
        System.out.println(x);
        System.out.println(x.add(y));
        System.out.println(x.sub(y));
        System.out.println(x.mul(y));
        System.out.println(x.div(y));

    }
}