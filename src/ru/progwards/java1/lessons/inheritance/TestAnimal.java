package ru.progwards.java1.lessons.inheritance;

public class TestAnimal {
    public static void printAnimal(Animal animal) {
        System.out.println(animal.toString() + " - " + animal.say() + "!");
    }

    public static void main(String[] args) {
        Cow cowP = new Cow("Пеструшка");
        printAnimal(cowP);
        Cow cowR = new Cow("Рыжая");
        printAnimal(cowR);
        Duck duckD = new Duck("Даша");
        printAnimal(duckD);
        Duck duckM = new Duck("Маша");
        printAnimal(duckM);
        Hamster hamA = new Hamster("Акакий");
        printAnimal(hamA);
        Hamster hamP = new Hamster("Поликарп");
        printAnimal(hamP);

    }
}
