package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public abstract  class AbsInteger {
      AbsInteger num;


    static AbsInteger   add(AbsInteger num1, AbsInteger num2) {
        BigInteger  sum=num1.value().add(num2.value());
        if ( -128 <= sum.intValue() && sum.intValue() <= 127  )
            return new ByteInteger(sum.byteValue());
        else if (-32768 <= sum.intValue() && sum.intValue() <= 32767 )
            return new ShortInteger(sum.shortValue());
        else return new IntInteger(sum.intValue());
    }

    public String toString() {
        return null;
    }
    public BigInteger value(){
        return null;
    } public static void main(String[] args) {
        ShortInteger sho= new ShortInteger((short) 300);
        IntInteger x= new IntInteger((int) 432767);
        System.out.println(x);
        ByteInteger byt= new ByteInteger((byte) 127);
        System.out.println(add(sho,byt));
    }
}

