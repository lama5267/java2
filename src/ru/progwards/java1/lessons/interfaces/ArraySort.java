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
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                CompareWeight c;
                if (a[i].getWeight() > a[j].getWeight()) {
                    c = a[i];
                    a[i] = a[j];
                    a[j] = c;
                }
            }

        }
    }
}
