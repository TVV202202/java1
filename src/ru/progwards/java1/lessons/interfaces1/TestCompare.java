package ru.progwards.java1.lessons.interfaces1;

import java.util.Arrays;

public class TestCompare {
    public static void main(String[] args) {
        Animal[] animals = new Animal[6];
        animals[0] = new Cow("Пеструшка", 350);
        animals[1] = new Cow("Рыжая", 250);
        animals[2] = new Duck("Даша", 3);
        animals[3] = new Duck("Маша", 3.5);
        animals[4] = new Hamster("Акакий", 0.25);
        animals[5] = new Hamster("Поликарп", 0.32);
        Arrays.sort(animals);
        System.out.println(Arrays.toString(animals));

    }
}
