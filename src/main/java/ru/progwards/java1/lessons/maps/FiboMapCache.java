package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    Map<Integer, BigDecimal> fiboCache;
    boolean cach;

    public FiboMapCache() {
        cach = false;
    }

    public FiboMapCache(boolean cacheOn) {
        cach = cacheOn;
        fiboCache = new HashMap<>();
    }

    public Map<Integer, BigDecimal> getFiboCache() {
        return fiboCache;
    }

    public BigDecimal fiboNumber(int n) {
        if (fiboCache == null)
            fiboCache = new HashMap<>();
        BigDecimal temp = new BigDecimal(0);

        if (cach && fiboCache.containsKey(n)) {//если есть  такое значение

            temp = fiboCache.get(n);//то присваиваем это значение

        } else {
            temp = (Fibo(n));
            fiboCache.put(n, temp);//добавляем пару ключ значение
        }
        return temp;
    }

    public BigDecimal Fibo(int n) {
        BigDecimal big1 = new BigDecimal(0);
        BigDecimal big2 = new BigDecimal(1);
        BigDecimal big;
        int i = 1;
        do {
            big = big1.add(big2);//добавляем элемент и присвоим значение
            big1 = big2;
            big2 = big;
            i++;
        } while (i < n);
        return big;
    }


    public void clearCahe() {
        fiboCache = null;//устанавливает переменную fiboCache в null
    }

    public static void test() {
        FiboMapCache cashON = new FiboMapCache(true);
        FiboMapCache cashOFF = new FiboMapCache(false);
        long start = 0;

        cashON.clearCahe();

        start = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            cashON.fiboNumber(i);
            System.out.println("on  " + i + ":" + cashON.fiboNumber(i));

        }
        long timeON = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            cashOFF.fiboNumber(i);
            System.out.println("off " + i + ":" + cashOFF.fiboNumber(i));
        }
        long timeOFF = System.currentTimeMillis() - start;


        System.out.println("fiboNumber cacheOn=true время выполнения " + timeON);
        System.out.println("fiboNumber cacheOn=falce время выполнения " + timeOFF);


    }

    public static void main(String[] args) {
        test();
    }
}
