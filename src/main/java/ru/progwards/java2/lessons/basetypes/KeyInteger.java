package ru.progwards.java2.lessons.basetypes;


public class KeyInteger implements HashValue {
    public int key;

    public KeyInteger(int key) {
        this.key = key;
    }

    @Override
    public int getHash() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyInteger)) return false;
        KeyInteger that = (KeyInteger) o;
        return key == that.key;
    }

    @Override
    public String toString() {
        return "" + key;
    }
}
