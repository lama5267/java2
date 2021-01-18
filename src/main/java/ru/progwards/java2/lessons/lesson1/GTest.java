package ru.progwards.java2.lessons.lesson1;

import java.util.List;

 public class GTest<T> {
    public void addAll(List<T> list, T... items) {
        for (T item: items) {
            list.add(item);
        }
    }
     public static <T extends Comparable<T>> GTest<T> from(List<T> list) {
         GTest<T> result = new GTest<>();
         //.. do something
         return result;
     }
     enum CompareResult {LESS, EQUAL, GREATER}
     public static <T extends Comparable<? super T>> CompareResult compare(T one, T two) {
         int result = one.compareTo(two);
         if(result==0)
             return CompareResult.EQUAL;
         else if(result < 0)
             return CompareResult.LESS;
         else return CompareResult.GREATER ;
     }
}