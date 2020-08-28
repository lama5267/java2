package ru.progwards.java1.lessons.bigints;

abstract public class AbsInteger {
    private static AbsInteger num1;
    private static AbsInteger num2;
    private static AbsInteger result;
    public int num;


    static AbsInteger   add(AbsInteger num1, AbsInteger num2) {
        String result = "";
        result +=(AbsInteger.num1+"+"+AbsInteger.num2);
        return AbsInteger.result;

    }

    @Override
    public String toString() {
        String result = "";
        result +=(num1+","+num2);
        return result;
    }
}

