package ru.progwards.java1.lessons.interfaces2;

import ru.progwards.java1.lessons.interfaces1.Color;

public class Hamster extends Animal {
    public Hamster(String name) {
        super(name);
    }

    public Hamster(String name, double weight) {
        super(name, weight);
    }

    public Hamster() {
    }

    @Override
    public String kind() {
        return "хомяк";
    }

    @Override
    public String say() {
        return "хрум-хрум-хрум";
    }

    @Override
    public Color getColor() {
        return Color.BEIGE;
    }

    @Override
    public String getHome() {
        return "поле";
    }
}
