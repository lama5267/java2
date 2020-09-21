package ru.progwards.java1.lessons.queues;

import java.util.PriorityQueue;

public class OrderQueue {
    PriorityQueue<PrioOrders> list = new PriorityQueue();
    //очередь с приоритетом
    public void add(Order order) {
        if (order.getSum() <= 10000) list.offer(new PrioOrders(order, 3));//3 - заказы до 10000 руб включительно

        if (order.getSum() > 10000 && order.getSum() <= 20000) list.offer(new PrioOrders(order, 2));
        //2 - заказы от 10000 до 20000 руб включительно
        if (order.getSum() > 20000) list.offer(new PrioOrders(order, 1));//1 - заказы от 20000 руб
    }


    static class PrioOrders implements Comparable<PrioOrders> {
        private Order ord;
        private int priority;

        public PrioOrders(Order ord, int priority) {
            this.ord = ord;
            this.priority = priority;
        }

        @Override
        public int compareTo(PrioOrders o) {
            return Integer.compare(priority, o.priority) == 0 ? Integer.compare(ord.getNum(), o.ord.getNum()) : Integer.compare(priority, o.priority);
        }

        @Override
        public String toString() {
            return priority + " " + ord;
        }
    }

    public Order get() {

        return list.isEmpty() ? null : list.poll().ord;//возвращающий первый заказ в очереди для обслуживания

    }

}
