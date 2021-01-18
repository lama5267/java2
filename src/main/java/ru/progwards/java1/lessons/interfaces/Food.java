package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food otherFood = (Food) smthHasWeigt;
        int fodcom = Double.compare(this.getWeight(), otherFood.getWeight());             //2
        switch (fodcom) {
            case (-1):
                return CompareWeight.CompareResult.LESS;                   //через if
            case (0):
                return CompareWeight.CompareResult.EQUAL;


        }
        return CompareWeight.CompareResult.GREATER;
    }


    @Override
    public double getWeight() {
        return weight;
    }



}
