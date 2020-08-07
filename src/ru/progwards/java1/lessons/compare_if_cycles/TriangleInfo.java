package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c){
        System.out.println("Вызвана функция isTriangle с параметрами: " + a + ", " + b + ", " + c);
        boolean x = true;
        if (a >= (b + c) | b >= (a+c) | c >= (a+b)) {
            x = false;
        }
        System.out.println("Результат: " + x);
        return x;
    }

    public static boolean isRightTriangle(int a, int b, int c){
        System.out.println("Вызвана функция isTriangle с параметрами: " + a + ", " + b + ", " + c);
        boolean x = false;
        if (a*a== (b*b)+(c*c) | b*b == (a*a)+(c*c) | c*c== (a*a)+(b*b)) {
            x =true ;
        }
        System.out.println("Результат: " + x);
        return x;
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c){
        System.out.println("Вызвана функция isTriangle с параметрами: " + a + ", " + b + ", " + c);
        boolean x = false;
        if (a == b  | b == c | c == a) {
            x =true ;
        }
        System.out.println("Результат: " + x);
        return x;
    }
    public static void main(String[] args) {
        isRightTriangle(10, 8, 6);

    }
}
