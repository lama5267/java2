package ru.progwards.java1.lessons.bigints;

class IntInteger extends AbsInteger {
    int num;

    public IntInteger(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "IntInteger{" +
                "num=" + num +
                '}';
    }
    public int anIntGetNum(int num) {
        return (int) num;
    }

}
