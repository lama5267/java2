package ru.progwards.java1.lessons.bigints;

class ShortInteger extends AbsInteger {
    short  num;

    public ShortInteger(short  num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String result = "";
        result += num ;
        return result;

    }
}
