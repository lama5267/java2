package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow) {   //num число, pow степень

        BigDecimal p = BigDecimal.ONE;

        while (pow != 0) {
            if (pow % 2 == 0) {
                pow = pow / 2;
                num = num.multiply(num);
            } else {
                pow--;
                p = num.multiply(p);
            }
        }
        return p;

    }



    static BigInteger fibonacci(int n) {
        BigInteger i1 = BigInteger.valueOf(1);
        BigInteger i2 = BigInteger.valueOf(1);
        BigInteger i3 = BigInteger.valueOf(0);
        int count = 3;
        if (n == 0 | n == 1 | n == 2) i3 = BigInteger.valueOf(1);
        while (count <= n) {
            i3 = i1.add(i2);       //сумма в  BigInteger
            i1 = i2;
            i2 = i3;
            count++;
        }
        return i3;
    }

    public static void main(String[] args) {

        BigAlgebra algebra = new BigAlgebra();
        System.out.println(algebra.fastPow(BigDecimal.valueOf(3), 7));
        System.out.println(algebra.fibonacci(8));

    }
}
