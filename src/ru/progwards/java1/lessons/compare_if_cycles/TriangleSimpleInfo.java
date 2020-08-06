package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c){
        if (a>b&b>c){
            System.out.println(a);
        }    int x=a;
        return x;
    }
        public static int minSide(int a, int b, int c){
        if (a>b&b>c){
            System.out.println(c);
        }    int x=c;
                System.out.println(c);

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
        maxSide(5,8,3);
    }
}
