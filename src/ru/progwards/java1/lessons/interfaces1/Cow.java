package ru.progwards.java1.lessons.interfaces1;

public class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }
    public Cow(String name, double weight){
        super(name, weight);
    }
    @Override
    public String kind() {
        return "корова";
    }

    @Override
    public String say() {
        return "мууууууу";
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    public static void main(String[] args) {
        Cow c1 = new Cow("qqq", 300);
        Cow c2 = new Cow("www", 400);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.compareTo(c2));
    }
}
