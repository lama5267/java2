package ru.progwards.java2.lessons.lesson1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BigHeapSize {
    public static String reverseChars(String str) {
        return str.isEmpty() ? "" : reverseChars(str.substring(1)) + str.charAt(0);
    }
    private String name;
    private int age;

    public BigHeapSize(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " " + age;
    }
    static void sortAndPrint(List<BigHeapSize> list){
        list.sort(Comparator.comparing(a -> a.age));
        list.forEach(element -> System.out.println(element));
    }
    public static void main(String[] args) {
        System.out.println(reverseChars("12345"));
        System.out.println(reverseChars("lama"));
        List<BigHeapSize> list = new ArrayList<>(List.of(
                new BigHeapSize("Петя", 27),
                new BigHeapSize("Коля", 33),
                new BigHeapSize("Маша", 18),
                new BigHeapSize("Сеня", 38),
                new BigHeapSize("Даша", 35)
        ));
        sortAndPrint(list);
    }
}