package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static boolean containsDigit(int number, int digit){
        return Integer.toString(number).contains(Integer.toString(digit));
        }
    public static int fiboNumber(int n) {
        int x = 1;
        int b = 0;
        int d = 0;
        for (int i = 1; i <= n; i++) {
            d = x + b;
            b = x;
            x = d;
            if (i == 1) {
                b = 0;
            }
        }
        return x;
    }
    public static boolean isGoldenTriangle(int a, int b, int c){
        return (a == b & (double)a/c >= 1.61703d & (double)a/c <= 1.61903d | a == c & (double)a/b  >= 1.61703d & (double)a/b  <= 1.61903d | b == c & (double)b/a  >= 1.61703d & (double)b/a  <= 1.61903d);
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            System.out.println(i + " - " + fiboNumber(i)); // Фибо - цикл
        }        for (int i = 1; i < 100; i++) {    // Цикл поиска золотых треугольников

            for (int j = 1; j <= i; j++) {
                if (isGoldenTriangle(i,i,j)){
                    System.out.println("Найден золотой треугольник с параметрами: " + i + ", " + i + ", " + j);
                }
            }
        }

        }
}