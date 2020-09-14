package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {


    private T[][] array;
    private int index = 0;
    private int index2 = 0;

    MatrixIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < array.length && index2 < array[index].length;
        //если длина массива и длина внутренних больше 0 и  то true;
    }

    @Override
    public T next() {
        if(index < array.length && index2 < array[index].length){
            T rezult = array[index][index2++];
            if(index2 >=  array[index].length){//для перехода к следующему вложеному массиву
                // увеличиваем индекс основного на единицу а для внутреннего берем индекс снова 0
                index++;
                index2 = 0;
            }
            return rezult;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Integer[][] integer = new Integer[][]{{1, 5, 6}, {2, 7, 9}, {3, 5}, {4}};

        MatrixIterator matrixIterator = new MatrixIterator(integer);

        System.out.println(matrixIterator.hasNext());
        System.out.println(matrixIterator.next());

        while (matrixIterator.hasNext()){
            System.out.println(matrixIterator.next());
        }
    }
}

