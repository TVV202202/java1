package Tester;

public class Dog implements Speaking {
    @Override
    public String say() {
        return "Гав";
    }
}

class Goat implements Speaking {
    @Override
    public String say() {
        return "Мее";
    }
}

