package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n) {
        this.digits = new byte[n];
    }
    void fromInt(BigInteger value) {


        String str = value.toString();

        char[] ch = new char[digits.length];

        for (int i = 0; i < ch.length; i++) {
            ch[i] = str.charAt(i);
        }
        String bi = new String(ch);

        BigInteger temp = new BigInteger(bi);
        for (int i = 0; i < digits.length; i++) {

            digits[i] = temp.remainder(BigInteger.TEN).byteValue();
            temp = temp.divide(BigInteger.TEN);

        }


    }

    BigInteger toInt() {
        String temp = "";
        for (int i = digits.length - 1; i >= 0; i--) {
            temp = temp + digits[i];
        }
        return new BigInteger(temp);
    }

    boolean add(ArrayInteger num) {
        byte cnt = 0;
        if (this.digits.length < num.digits.length) return false;

        byte[] mas = Arrays.copyOf(num.digits, this.digits.length);
        System.out.println("mas=" + Arrays.toString(mas));
        for (int i = 0; i < this.digits.length; i++) {
            byte temp = (byte) (this.digits[i] + mas[i] + cnt);
            if (temp >= 10) {
                this.digits[i] = (byte) (temp % 10);
                cnt = 1;
            } else {
                this.digits[i] = temp;
                cnt = 0;
            }
        }
        if (cnt != 0) {
            Arrays.fill(this.digits, (byte) 0);
            return false;
        }
        return true;

    }
    public static void main(String[] args) {
        ArrayInteger arr = new ArrayInteger(6);
        ArrayInteger arr2 = new ArrayInteger(5);
        arr.fromInt(new BigInteger("597746"));
        arr2.fromInt(new BigInteger("55703"));
        System.out.println(Arrays.toString(arr.digits));
        System.out.println(arr.toInt());
        System.out.println(arr.add(arr2));
        System.out.println(Arrays.toString(arr.digits));
        System.out.println(arr.toInt());
    }

}
