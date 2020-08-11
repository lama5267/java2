package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;
    public Animal(double weight){

        this.weight=weight;
    }
    public enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        Duck

    }
    public AnimalKind getKind(){
        return AnimalKind.ANIMAL;
    }
    public enum FoodKind {
        UNKNOWN,
        HAY,
        CORN
    }
    public FoodKind  getFoodKind(){
        return FoodKind.UNKNOWN;
    }
    public double  getWeight(){
        return weight;
    }
    public double getFoodCoeff(){
        double ves=0.02;
        return ves;
    }
    public double calculateFoodWeight(){
        double  vese=getWeight()*getFoodCoeff();
        return vese;
    }
    public String toString() {
        return "I am" +" "+ getKind() + ", eat" + " "+getFoodKind();

    }
    public String toStringFull() {
        return "I am" +" " +getKind() + ", eat" + " "+getFoodKind() + " "+calculateFoodWeight();
    }
    }


