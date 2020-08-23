package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare, CompareWeight {



    enum AnimalKind {
        ANIMAL, COW, HAMSTER, DUCK
    }

    enum FoodKind {UNKNOWN, HAY, CORN}

    double weight;



    public double getFood1kgPrice() {

        switch (getFoodKind()) {
            case HAY:                                                           //1
                return 20;
            case CORN:                                                          //1
                return 50;
            case UNKNOWN:
            default:
                return 0;
        }

    }

    public Animal(double weight) {
        this.weight = weight;
    }
    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal animal = (Animal) smthHasWeigt;
        int doubcom = Double.compare(this.getWeight(), animal.getWeight());
        switch (doubcom) {
            case (-1):
                return CompareWeight.CompareResult.LESS;
            case (0):
                return CompareWeight.CompareResult.EQUAL;


        }
        return CompareWeight.CompareResult.GREATER;
    }



    @Override
    public double getWeight() {
        return this.weight;
    }


    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    public double getFoodPrice() {
        return this.calculateFoodWeight() * this.getFood1kgPrice();

    }


    public String toString() {
        return ("I am " + this.getKind() + ", eat " + this.getFoodKind());
    }


    public double getFoodCoeff() {
        switch (getKind()) {
            default:
                return 0.02;
        }
    }

    public double calculateFoodWeight() {
        return this.getWeight() * this.getFoodCoeff();
    }


    public String toStringFull() {
        return ("I am " + this.getKind() + ", eat " + this.getFoodKind() + " " + this.calculateFoodWeight());
    }


    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        return Double.compare(animal.getWeight(), getWeight()) == 0;
    }

    public static void main(String[] args) {
        Cow mu = new Cow(500);
        Duck kra = new Duck(7);
        Hamster meat = new Hamster(10);
        System.out.println(mu.compareWeight(mu));
        System.out.println(mu.compareWeight(kra));
        System.out.println(mu.compareWeight(meat));
    }
}
