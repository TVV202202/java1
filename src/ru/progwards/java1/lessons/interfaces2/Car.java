package ru.progwards.java1.lessons.interfaces2;

import static ru.progwards.java1.lessons.interfaces2.ArraySort.sort;

public class Car implements CompareWeight {
    private double weight;

    public Car(double weight) {
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Это автомобиль грузоподъемностью " + weight;
    }



    public static void main(String[] args) {
        Car car1 = new Car(500);
        Car car2 = new Car(450);
        Cow cow1 = new Cow("rrr", 320);
        Cow cow2 = new Cow("gbt", 250);
        Duck duck = new Duck("ooio", 3.5);
        CompareWeight[] spisok = {cow2, duck, car1, cow1, car2};
        sort(spisok);
        for (CompareWeight el : spisok)
            System.out.println(el);

    }
}
