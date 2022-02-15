package ru.progwards.java1.lessons.classescompare;

abstract class Animal {
    String name;
    double weight;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String kind();

    public abstract String say();

    public String toString() {
        return "Это " + kind() + " " + this.name;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
    int compareTo(Animal animal){
        if (this.weight == animal.weight)
            return 0;
        else if (this.weight > animal.weight)
            return 1;
        else
            return -1;
    }
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        return (o instanceof Animal animal) && (this.name == animal.name) && (this.kind() == animal.kind()) && (this.weight == animal.weight);
    }

    enum FoodKind{
        HAY, CORN
    }
    abstract public FoodKind getFoodKind();
    abstract public double getFoodCoeff();
    public double calculateFoodWeight(){
        return weight * getFoodCoeff();
    }
    public double calculateFoodPrice(){
        int price;
        if (getFoodKind() == FoodKind.HAY)
            price = 2;
        else
            price = 15;
        return calculateFoodWeight() * price;
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
    @Override
    public FoodKind getFoodKind(){
        return FoodKind.HAY;
    }
    @Override
    public double getFoodCoeff(){
        return 0.05;
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
    @Override
    public FoodKind getFoodKind(){
        return FoodKind.CORN;
    }
    @Override
    public double getFoodCoeff() {
        return 0.06;
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
    @Override
    public FoodKind getFoodKind(){
        return FoodKind.CORN;
    }
    @Override
    public double getFoodCoeff() {
        return 0.04;
    }
}

class TestAnimal {
    public static void printAnimal(Animal animal) {
        System.out.println(animal.toString() + " - " + animal.say() + "!");
    }

    public static void main(String[] args) {
        System.out.println("Тест для Animal, Cow, Hamster, Duck");

        Cow cow1 = new Cow("Пеструшка");
        cow1.setWeight(300);
        Cow cow2 = new Cow("Рыжая");
        cow2.setWeight(350);
        Cow cow3 = new Cow("Пеструшка");
        cow3.setWeight(400);
        System.out.println("cow1 (300) vs cow3 (400)");
        System.out.println(cow1.equals(cow3));
        cow3.setWeight(300);
        System.out.println("cow1 (300) vs cow3 (300)");
        System.out.println(cow1.equals(cow3));
        System.out.println("кто больше cow1 (300) vs cow2 (350)");
        System.out.println(cow1.compareTo(cow2));
        System.out.println("кто больше cow1 vs cow3");
        System.out.println(cow1.compareTo(cow3));
        System.out.println("кто больше cow2 vs cow3");
        System.out.println(cow2.compareTo(cow3));


        Duck duck1 = new Duck("Даша");
        duck1.setWeight(4.5);
        Duck duck2 = new Duck("Маша");
        duck2.setWeight(5);


        Hamster ham1 = new Hamster("Акакий");
        ham1.setWeight(0.1);
        Hamster ham2 = new Hamster("Поликарп");
        ham2.setWeight(0.12);

        System.out.println("cow1 (300) vs duck2 (4.5)");
        System.out.println(cow1.equals(duck2));
        System.out.println("кто больше ham1 (0.1) vs duck2 (4.5)");
        System.out.println(ham1.compareTo(duck2));

        printAnimal(cow1);
        System.out.println(cow1.calculateFoodWeight());
        System.out.println(cow1.calculateFoodPrice());
        printAnimal(duck1);
        System.out.println(duck1.calculateFoodWeight());
        System.out.println(duck1.calculateFoodPrice());
        printAnimal(ham1);
        System.out.println(ham1.calculateFoodWeight());
        System.out.println(ham1.calculateFoodPrice());

    }
}
