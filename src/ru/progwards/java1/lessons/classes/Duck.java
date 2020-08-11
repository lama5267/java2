package ru.progwards.java1.lessons.classes;

public class Duck extends Animal{

    public Duck(double weight) {
        super(weight);
    }

    public AnimalKind getKind(){
        return AnimalKind.Duck;
    }
    public FoodKind  getFoodKind(){
        return FoodKind.CORN ;
    }
    public double getFoodCoeff(){
        double ves=0.04;
        return ves;
    }
}
