package ru.progwards.java1.lessons.interfaces2;

public class TestString {
    public static void print(ToString any) {
        System.out.println(any.getString());
    }

    public static void main(String[] args) {
        Cow cow = new Cow("Пеструшка");
        Duck duck = new Duck("Даша");
        Hamster hamster = new Hamster("Поликарп");
        Time time = new Time(1, 12, 55);
        ComplexNum complex = new ComplexNum(22, 5);
        print(cow);
        print(duck);
        print(hamster);
        print(time);
        print(complex);
    }
}
