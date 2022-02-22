package ru.progwards.java1.lessons.interfaces1;

public abstract class Animal implements Comparable<Animal>, IColor{
    String name;
    double weight;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public abstract String kind();

    public abstract String say();

    public String toString() {
        return "Это " + kind() + " " + this.name + " " + this.weight + " " + getColor();
    }

    @Override
    public int compareTo(Animal o){
        return Double.compare(this.weight, o.weight);
    }


}

