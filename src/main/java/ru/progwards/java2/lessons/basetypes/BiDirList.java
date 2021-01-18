package ru.progwards.java2.lessons.basetypes;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BiDirList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return getIterator();
    }

    class ListItem<T> {

        private T item;
        private ListItem<T> next;
        private ListItem<T> prev;

        ListItem(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        void setNext(ListItem<T> item) {
            next = item;
        }

        void setPrev(ListItem<T> item) {
            prev = item;
        }

        ListItem<T> getNext() {
            return next;
        }

        ListItem<T> getPrev() {
            return prev;
        }

    }

    private ListItem<T> head;
    private ListItem<T> tail;
    private int size;

    ListItem<T> getHead() {
        return head;
    }

    ListItem<T> getTail() {
        return tail;
    }

    public void addLast(T item) { // добавить в конец списка
        ListItem<T> list = new ListItem<T>(item);
        if (head == null) {
            head = list;
            tail = list;
        } else {
            tail.setNext(list);
            list.setPrev(tail);
            tail = list;
        }
        size++;
    }

    public void addFirst(T item) { // добавить в начало списка
        ListItem<T> list = new ListItem<T>(item);
        if (head == null) {
            head = list;
            tail = list;
        } else {
            head.setPrev(list);
            list.setNext(head);
            head = list;
        }
        size++;
    }

    public void remove(T item) { // удалить
        ListItem<T> current = getHead();
        while(current != null) {
            if(item.equals(current.getItem())) {
                ListItem<T> prevItem = current.getPrev();
                if(prevItem != null) {
                    prevItem.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                ListItem<T> nextItem = current.getNext();
                if(nextItem != null) {
                    nextItem.setPrev(current.getPrev());
                } else {
                    tail = current.getPrev();
                }
                size--;
                return;
            }
            current = current.getNext();
        }
        throw new NoSuchElementException();
    }

    public T at(int i) { // получить элемент по индексу
        if(i >= size() || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        ListItem<T> current = getHead();
        while(current != null) {
            if(counter == i) {
                return current.getItem();
            }
            current = current.getNext();
            counter++;
        }
        return null;
    }

    public int size() { // получить количество элементов
        return size;
    }

    public static<T> BiDirList<T> from(T[] array) { // конструктор из массива
        BiDirList<T> list = new BiDirList<>();
        for(T elem : array) {
            list.addLast(elem);
        }
        return list;
    }

    public static<T> BiDirList<T> of(T...array) { //  конструктор из массива
        return BiDirList.from(array);
    }

    public T[] toArray(T[] array) { // скопировать в массив
        int sizeOfList = size();
        if (array.length < sizeOfList) {
            array = (T[]) new Object[sizeOfList];
        }
        ListItem<T> elem = getHead();
        for(int i = 0; i < array.length; i++) {
            if (i > sizeOfList) {
                array[i] = null;
            } else {
                array[i] = elem.getItem();
                elem = elem.getNext();
            }
        }
        return array;
    }

    public Iterator<T> getIterator() { // получить итератор
        return new Iterator<T>() {
            private ListItem<T> currentListItem = getHead();
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                ListItem<T> listItemToReturn = currentListItem;
                currentListItem = currentListItem.getNext();
                index++;
                return listItemToReturn.getItem();
            }
        };
    }
    }
