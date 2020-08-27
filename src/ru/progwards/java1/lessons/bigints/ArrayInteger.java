package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n) {
        this.digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (byte) value.mod(BigInteger.TEN).intValue();
            value = value.divide(BigInteger.TEN);
        }
    }

    BigInteger toInt() {
        BigInteger value = BigInteger.valueOf(0);
        long i = 1L;
        for (byte digist : digits){
            if (digist == 0){
                i *= 10;
                continue;
            } else {
                value = value.add(BigInteger.valueOf(digist * i));
                i *= 10;
            }
        }
        return value;
    }

    boolean add(ArrayInteger num) {
        for (int i = 0; i < digits.length; i++) {
            if (this.digits[digits.length-1] + num.digits[num.digits.length-1] > 9) {
                for (int j = 0; j < this.digits.length; j++){
                    this.digits[j] = 0;
                }
                return false;
            } else if (this.digits[i] + num.digits[i] > 9) {
                this.digits[i] += num.digits[i];
                this.digits[i] %= 10;
                this.digits[i+1] += 1;
            } else {
                this.digits[i] += num.digits[i];
            }
        }
        return true;
    }
}
