package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;                  //5

    public static int fiboNumber(int n) {
        if (lastFibo != null && lastFibo.n == n)
            return lastFibo.fibo;
        int i1 = 1;
        int i2 = 1;
        int i3 = 0;
        int count = 3;
        if (n == 0 | n == 1 | n == 2) i3 = 1;
        while (count <= n) {
            i3 = i1 + i2;
            i1 = i2;
            i2 = i3;
            count++;
        }
        lastFibo = new CacheInfo(n, i3);
        return i3;
    }

    public static class CacheInfo {

        public int n;
        public int fibo;

        public CacheInfo(int n, int fibo) {
            this.n = n;
            this.fibo = fibo;
        }


    }

    public static void main(String[] args) {
        System.out.println(fiboNumber(10));
        fiboNumber(10);

    }

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }
}
