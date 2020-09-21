package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {
    ArrayDeque<Double> coll = new ArrayDeque<>();//наиболее удобная для стека колл


    public void push(double value) {
        coll.push(value);//положили на вершину стека
    }

    public double pop() {
        return coll.pop();//убрали значение с вершины стека
    }

    public void add() {
        double temp = coll.pop();//
        coll.push(coll.pop() + temp);//сложили два верхних значения на стеке и положили на стек
    }

    public void sub() {
        double temp = coll.pop();
        coll.push(coll.pop() - temp);//вычли два верхних  значения на стеке и положили на стек
    }

    public void mul() {
        double temp = coll.pop();
        coll.push(coll.pop() * temp);//умножили два верхних значения на стеке и положили на стек
    }

    public void div() {
        double temp = coll.pop();
        coll.push(coll.pop() / temp);//поделили два верхних значения на стеке и положили на стек
    }
}
