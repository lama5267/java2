package ru.progwards.java1.lessons.arrays;

public class BIntArray {
    int[] array;
    int size;
    int block;

    public BIntArray(int initSize, int blockSize) {
        size = 0;
        array = new int[initSize];
        block = blockSize;
    }

    public void add(int item) {
        if (size == array.length) {
            int[] newArray = new int[array.length + block];
            copyData(array, newArray);
            array = newArray;
        }
        array[size++] = item;
    }

    void copyData(int[] src, int[] dst) {
        for(int i=0; i<src.length; i++)
            dst[i] = src[i];
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        return size;
    }}
