package ru.progwards.java1.lessons.interfaces;

public class ArraySort implements CompareWeight {
    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        return null;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    public static void sort(CompareWeight[] a) {
        CompareWeight a1;
        for (int i=0; i<a.length; i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareWeight.CompareResult.GREATER) {
                    a1 = a[i];
                    a[i] = a[j];
                    a[j] = a1;
                }
            }
        }
    }

}
