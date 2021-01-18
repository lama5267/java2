package ru.progwards.java2.lessons.basetypes;

import java.util.Objects;

public class StringHashValue implements HashValue{
    public String key;
    private static final long UINT_MAX = 4294967295L;

    public StringHashValue(String key) {
        this.key = key;
    }
    private long unsignedInt(long num) {
        return num % UINT_MAX;
    }

    @Override
    public int getHash() {
        long b = 378551;
        long a = 63689;
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (int)unsignedInt(hash * a + key.charAt(i));
            a = unsignedInt(a * b);
        }
        return Math.abs(hash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringHashValue)) return false;
        StringHashValue that = (StringHashValue) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public String toString() {
        return "" + key;
    }

}
