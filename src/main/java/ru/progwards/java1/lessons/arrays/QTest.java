package ru.progwards.java1.lessons.arrays;

public class QTest {
    public static void main(String[] args) throws Exception {
        QIntArray q = new QIntArray(1000);

        q.offer(10);
        q.offer(12);
        q.offer(25);
        q.offer(34);
        q.offer(45);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
