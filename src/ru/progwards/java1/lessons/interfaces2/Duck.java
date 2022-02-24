package ru.progwards.java1.lessons.interfaces2;

import ru.progwards.java1.lessons.interfaces1.Color;

public class Duck extends Animal {
    public Duck(String name) {
        super(name);
    }

    public Duck(String name, double weight) {
        super(name, weight);
    }

    public Duck() {
    }

    @Override
    public String kind() {
        return "утка";
    }

    @Override
    public String say() {
        return "кря-кря";
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String getHome() {
        return "ферма";
    }
}
