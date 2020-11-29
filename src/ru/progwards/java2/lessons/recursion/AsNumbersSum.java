package ru.progwards.java2.lessons.recursion;

public class AsNumbersSum {
    public static String asNumbersSum(int number) {
        return number + sortNumber(number, 1, "");
    }

    public static String sortNumber(int number, int secondTerm, String lastTerm) {
        if(number == 1)
            return "";
        if(number/2 < secondTerm)
            return sortNumber(number-1, 1, lastTerm + "+1");
        return " = " + (number-secondTerm) + "+" + secondTerm + lastTerm + sortNumber(number, secondTerm+1, lastTerm);

    }

    public static void main(String[] args) {
        System.out.println(asNumbersSum(5));
        System.out.println("5 = 4+1 = 3+2 = 3+1+1 = 2+2+1 = 2+1+1+1 = 1+1+1+1+1".equals(asNumbersSum(5)));
    }
}
