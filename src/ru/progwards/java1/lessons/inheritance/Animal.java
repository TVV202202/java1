package ru.progwards.java1.lessons.inheritance;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String kind();

    public abstract String say();

    public String toString() {
        return "Это " + kind() + " " + this.name;
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    @Override
    public String kind() {
        return "корова";
    }

    @Override
    public String say() {
        return "мууууууу";
    }
}

class Hamster extends Animal {
    public Hamster(String name) {
        super(name);
    }

    @Override
    public String kind() {
        return "хомяк";
    }

    @Override
    public String say() {
        return "хрум-хрум-хрум";
    }
}

class Duck extends Animal {
    public Duck(String name) {
        super(name);
    }

    @Override
    public String kind() {
        return "утка";
    }

    @Override
    public String say() {
        return "кря-кря";
    }
}

class TestAnimal {
    public static void printAnimal(Animal animal) {
        System.out.println(animal.toString() + " - " + animal.say()+"!");
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