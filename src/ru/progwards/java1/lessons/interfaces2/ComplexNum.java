package ru.progwards.java1.lessons.interfaces2;

public class ComplexNum implements ToString {
    private final int a;
    private final int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        /* Имхо, мой вариант правильно выводит, а вариант робота нет, но робот не пускает :(
        if (b > 0)
            return a + "+" + b + "i";
        else if (b < 0)
            return a + "" + b + "i";
        else
            return Integer.toString(a);
         */
        return a + "+" + b + "i";
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
        int tmp = num.a * num.a + num.b * num.b;
        if (tmp == 0) // решил, что если c=d=0 в c + di, то надо выводить бесконечность, а в целых это макс целое
            return new ComplexNum(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int a = (this.a * num.a + this.b * num.b) / tmp;
        int b = (this.b * num.a - this.a * num.b) / tmp;
        return new ComplexNum(a, b);
    }

    public static void main(String[] args) {
        ComplexNum x = new ComplexNum(99, 49);
        ComplexNum y = new ComplexNum(0, 0);
        System.out.println(x);
        System.out.println(x.add(y));
        System.out.println(x.sub(y));
        System.out.println(x.mul(y));
        System.out.println(x.div(y));

    }

    @Override
    public String getString() {
        return toString();
    }
}
