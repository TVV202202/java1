package Tester;

class Dog implements Speaking, Eating {
    @Override
    public String say() {
        return "Гав";
    }
    @Override
    public String eat(){
        return "Мясо";
    }

}

class Goat implements Speaking, Eating {
    @Override
    public String say() {
        return "Мее";
    }
    @Override
    public String eat() {
        return "Сено";
    }
}

class TestAni {
    public static void main(String[] args) {
        //Dog dog = new Dog();
        //Goat goat = new Goat();
        //System.out.println(dog.say() + " " + dog.eat());
        Temperature t = new Man();
        //Sun s = (Sun) t;
        test((Body) t);
    }
    public static double sumFuits(Fruit[] box){
        double res=0;
        for (Fruit el: box){
            res += el.getWeight();
        }
        return res;
    }
    public static Temperature maxTemperature(Body b1, Body b2){
        if (b1.getTemperature() >= b2.getTemperature())
            return b1;
        else
            return b2;
    }
    static void test(Temperature t) {
        Man m = (Man) t;
    }

}

abstract public class Body implements Temperature {
}

