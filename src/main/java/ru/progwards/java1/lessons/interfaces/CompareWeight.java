package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {

    public enum CompareResult {LESS, EQUAL, GREATER}




    //    default
    CompareResult compareWeight(CompareWeight smthHasWeigt);



    public double getWeight();}
