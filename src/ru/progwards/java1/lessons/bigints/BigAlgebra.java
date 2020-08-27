package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
  static  BigDecimal fastPow(BigDecimal num, int pow) {
        if (pow == 0) return BigDecimal.valueOf(1);        //проверка нулевой степени
        String stepen = Integer.toString(pow, 2);      //представление степени двоичным числом
        BigDecimal resul = (num);             //инициализация результата НУЛЕМ
        for (int i = stepen.length() - 1; i > 0; i--) {    //цикл перебора от СТАРШЕГО бита к МЛАДШЕМУ
            if (stepen.charAt(i) == '1') {                  //считывание значения бита
                resul = (resul.multiply(resul)).multiply(num);
            } else resul = resul.multiply(resul);
        }
        return resul;
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
        System.out.println(algebra.fastPow(BigDecimal.valueOf(3), 8));
        System.out.println(algebra.fibonacci(8));

    }
}
