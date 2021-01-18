package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number){
        int a=number%10;
        int b=number%100/10;
        int c=number/100;
        int x=a*100+b*10+c;

        System.out.print(x);

        return(x);
    }
    public static void main(String[] args){
        reverseDigits(123);

    }

}
