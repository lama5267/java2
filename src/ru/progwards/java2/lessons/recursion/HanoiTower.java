package ru.progwards.java2.lessons.recursion;

public class HanoiTower {
int size;
int pos;

    public HanoiTower(int size,int pos) {
        this.size = size;
        this.pos = pos;
    }
    public void move(int from, int to) {
        int middle;
        if (to == 2)
            middle = 3;
        else {
            to = 3;
            middle = 2;
        }
        movePartOfTower(size, from, to, middle);
    }
    public void movePartOfTower(int n, int from, int to, int middle) {
        if (n == 0)
            return;

        movePartOfTower(n - 1, from, middle, to);

        System.out.println(from + " " + to);

        movePartOfTower(n - 1, middle, to, from);
    }

    public void print() {
        System.out.println();
    }

    public void setTrace(boolean on) {

    }


    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower(3, 0);
        hanoiTower.move(1, 2);
    }
}
