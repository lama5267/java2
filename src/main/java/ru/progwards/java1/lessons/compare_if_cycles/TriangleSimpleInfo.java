package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c){
        System.out.println("Вызвана функция maxSide с параметрами " + a + ", " + b + ", " + c);
        int x = a;
        if (x < b) {
            x = b;
        }
        if (x < c) {
            x = c;
        }
        System.out.println("Самая длинная сторона треугольника =  " + x);
        return x;
    }
        public static int minSide(int a, int b, int c){
            System.out.println("Вызвана функция maxSide с параметрами " + a + ", " + b + ", " + c);
            int x = a;
            if (x >  b) {
                x = b;
            }
            if (x >  c) {
                x = c;
            }
            System.out.println("Самая короткая сторона треугольника =  " + x);
            return x;
        }
    public static boolean  isEquilateralTriangle(int a, int b, int c){
        System.out.println("Вызвана функция isTriangle с параметрами: " + a + " = " + b + " = " + c);
        boolean x= false;

        if (a==b&b==c){
x=true;
}
        System.out.println("Результат: " + x);
        return x;
    }

    public static void main(String[] args) {
        minSide(1,4,2);
    }
}
