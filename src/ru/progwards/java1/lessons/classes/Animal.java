package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;

    public Animal(double weight) {
        this.weight = weight;

    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    enum FoodKind {
        UNKNOWN,
        HAY,
        CORN
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    @Override
    public String toString() {
        return "I am" +" "+ getKind() + ", eat" + " "+getFoodKind();

    }

    public double calculateFoodWeight() {
        return weight * getFoodCoeff();
    }

    public String toStringFull() {
        return "I am" +" " +getKind() + ", eat" + " "+getFoodKind() + " "+calculateFoodWeight();
    }
}


