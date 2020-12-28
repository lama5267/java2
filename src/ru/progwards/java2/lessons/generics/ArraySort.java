package ru.progwards.java2.lessons.generics;

import java.util.Arrays;

public class ArraySort {
    private static <T extends Comparable<T>> void sort(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                T temp;
                if (arr[i].compareTo(arr[j]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {

        Integer[] i = {2, 1, 7, -1, 22, 1, 3,5};
        Double[] d = {2.2, 1.8, 4.0, 4.7, -3.5};
        sort(i);
        sort(d);
    }
}
