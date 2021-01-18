package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int index = 0;

    ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < array.length;//если длина массива больше 0 то true;
    }

    @Override
    public T next() {
        if(index < array.length){
            return array[index++];
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        Integer[] integer = new Integer[]{2, 6, 9, 7, 4, 5};

        ArrayIterator arrayIterator = new ArrayIterator(integer);

        System.out.println(arrayIterator.hasNext());
        System.out.println(arrayIterator.next());
        while (arrayIterator.hasNext()){
            System.out.println(arrayIterator.next());
        }
    }
}

