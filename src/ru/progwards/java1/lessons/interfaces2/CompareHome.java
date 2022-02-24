package ru.progwards.java1.lessons.interfaces2;

public class CompareHome {
    public static boolean sameHome(Home h1, Home h2) {
        boolean bool = h1.getHome().equals(h2.getHome());
        System.out.print("Результат сравнения ");
        System.out.println(h1.getClass().getSimpleName() + " и " + h2.getClass().getSimpleName() + " равен " + bool);
        return bool;
    }

    public static void main(String[] args) {
        Cow cow = new Cow();
        Duck duck = new Duck();
        Hamster hamster = new Hamster();
        Hawk hawk = new Hawk();
        sameHome(cow, duck);
        sameHome(cow, hamster);
        sameHome(cow, hawk);
        sameHome(duck, hamster);
        sameHome(duck, hawk);
        sameHome(hamster, hawk);
    }
}
