package ru.progwards.java2.lessons.generics;

import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<T> {
    private T[] arr;

    public DynamicArray() {
    }

    private int realSize() {
        return (int) Arrays.stream(arr).filter(Objects::nonNull).count();
    }

    private void add(T element) {
        if (arr.length == realSize()) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[realSize()] = element;
    }

    private void insert(int pos, T element) {
        if (pos < 0 || pos > arr.length - 1)
            return;

        if (arr.length == realSize()) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }

        T[] tempArr = Arrays.copyOfRange(arr, pos, arr.length);

        arr[pos] = element;

        int index = 0;
        for (int i = pos + 1; i < arr.length; i++) {
            arr[i] = tempArr[index];
            index++;
        }
    }

    private void remove(int pos) {
        if (pos < 0 || pos > arr.length - 1)
            return;

        T[] tempArr = Arrays.copyOfRange(arr, pos + 1, arr.length);
        arr = Arrays.copyOf(arr, arr.length - 1);

        int index = 0;
        for (int i = pos; i < arr.length; i++) {
            arr[i] = tempArr[index];
            index++;
        }
    }

    private void get(int pos) {
        if (pos < 0 || pos > arr.length - 1)
            return;

        System.out.println(arr[pos]);
    }

    private void size() {
        System.out.println(realSize());
    }


    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.arr = new Integer[]{3, 1, 8, 4};
dynamicArray.add(16);
dynamicArray.insert(2,7);
dynamicArray.remove(3);
dynamicArray.get(4);
dynamicArray.size();
        System.out.println(Arrays.toString(dynamicArray.arr));
    }
}