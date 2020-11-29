package ru.progwards.java1.lessons.arrays;

import java.util.ArrayList;

public class PIntArray {
    ArrayList<int[]> array;
    int size;
    int block;
    int[] page;


    public PIntArray(int blockSize) {
        size = 0;
        array = new ArrayList<>();
        block = blockSize;
        page = new int[block];
        array.add(page);
    }

    public void add(int item) {
        if (size == page.length) {
            page = new int[block];
            array.add(page);
            size = 0;
        }
        page[size++] = item;
    }

    public int get(int index) {
        int index1 = index / block;
        int index2 = index % block;
        return array.get(index1)[index2];
    }

    public int size() {
        return ((array.size()-1)*block)+size;
    }
}
