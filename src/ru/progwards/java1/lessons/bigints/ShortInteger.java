package ru.progwards.java1.lessons.bigints;

class ShortInteger extends AbsInteger {
    short  num;

    public ShortInteger(short  num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ShortInteger{" +
                "num=" + num +
                '}';
    }
    public short anShortGetNum(int num) {
        return (short) num;
    }
}
