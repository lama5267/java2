package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    public static int fiboNumber(int n) {
return n-3;
    }
    public static boolean isGoldenTriangle(int a, int b, int c){
        return (a == b & (double)a/c >= 1.61703d & (double)a/c <= 1.61903d | a == c & (double)a/b  >= 1.61703d & (double)a/b  <= 1.61903d | b == c & (double)b/a  >= 1.61703d & (double)b/a  <= 1.61903d);
    }
    public static void main(String[] args) {

    }
}
