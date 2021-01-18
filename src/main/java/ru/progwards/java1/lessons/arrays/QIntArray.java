package ru.progwards.java1.lessons.arrays;

public class QIntArray {
    int[] array;
    int head;
    int tail;

    public QIntArray(int size) {
        array = new int[size];
        head = tail = 0;
    }

    public void offer(int item) {
        if (++tail == array.length)
            tail = 0;
        // if tail == head // надо расширяться
        array[tail] = item;
    }

    public int poll() throws Exception {
        if (head == tail)
            throw new Exception("no date");
        return array[head++];
    }
}
