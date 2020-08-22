package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    public int N;
    private boolean[] sieve;

    public Eratosthenes(int N) {
        this.N = N;
        sieve = new boolean[N];
        Arrays.fill(sieve, true);
        this.sift();
    }

    private void sift() {
        int i, j;
        for (i = 2; i < sieve.length; i++) {
            for (j = 2; j < sieve.length; j++) {
                if (i * j <= 3) {
                    sieve[i * j] = true;
                    continue;
                }

                while ((sieve.length - 1) >= i * j) {
                    sieve[j * i] = false;
                    j++;
                }
            }
        }
    }

    public boolean isSimple(int n) {
        return sieve[n];
}
}