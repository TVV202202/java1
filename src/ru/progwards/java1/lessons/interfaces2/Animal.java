package ru.progwards.java1.lessons.interfaces2;

import ru.progwards.java1.lessons.interfaces1.Color;

public abstract class Animal implements Comparable<Animal>, IColor, Home, ToString, CompareWeight {
    String name;
    double weight;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Animal() {
    }

    public abstract String kind();

    public abstract String say();

    public abstract Color getColor();

    public String toString() {
        return "Это " + kind() + " " + name + " " + weight + " " + getColor();
    }

    @Override
    public int compareTo(Animal o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public String getString() {
        return toString();
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight) {
        if (weight < smthHasWeight.getWeight())
            return CompareResult.LESS;
        else if (weight == smthHasWeight.getWeight())
            return CompareResult.EQUAL;
        else
            return CompareResult.GREATER;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}

