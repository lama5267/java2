package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Creator {
    public static Collection<Integer> fillEven(int n)    {
        List<Integer> list=new ArrayList<>();
       int x=0;
        for (int i=0; i<n; i++){
           x+=2;//делаем четными возрастающими
            list.add(x);
        }
        return list;
    }
    public static Collection<Integer> fillOdd(int n)    {
        int x = n*2+1;//делаем нечетными
        List<Integer> list=new ArrayList<>();
        for (int i=0; i<n; i++){
           x-=2;//убывающими числами
            list.add(x);
        }
        return list;
    }
    public static Collection<Integer> fill3(int n){
        List <Integer> col= new LinkedList();
        ListIterator lsi= col.listIterator();//создаем итератор
        for (int i=0; i<n; i++){
            int ind=lsi.nextIndex();//получаем следующий элемент индекса
            lsi.add(ind);
            lsi.add((ind)*(ind));
            lsi.add((ind)*(ind)*(ind));
        }
        return col;
    }



    public static void main(String[] args) {
        System.out.println(fillEven(10));
        System.out.println(fillOdd(10));
        System.out.println(fill3(10));
    }
}
