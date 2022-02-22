package ru.progwards.java1.lessons.interfaces1;

public class Animal implements Comparable<Animal>, IColor{
    String name;
    double weight;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public String kind(){
        return "";
    }

    public String say(){
        return "";
    }

    @Override
    public Color getColor() {
        return null;
    }

    public String toString() {
        return "Это " + kind() + " " + this.name + " " + this.weight + " " + getColor();
    }

    @Override
    public int compareTo(Animal o){
        return Double.compare(this.weight, o.weight);
    }


}

