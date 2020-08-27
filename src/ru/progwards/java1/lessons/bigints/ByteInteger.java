package ru.progwards.java1.lessons.bigints;

class ByteInteger extends AbsInteger {
    byte num;

    public ByteInteger(byte num) {
        this.num = num;
    }


    @Override
    public String toString() {
        return "ByteInteger{" +
                "num=" + num +
                '}';
    }
}
