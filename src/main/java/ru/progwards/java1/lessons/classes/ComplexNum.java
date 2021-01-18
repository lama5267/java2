package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a;
    int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + "+" + b + "i";
    }

    public ComplexNum add(ComplexNum num) {
        int actual = this.a + num.a;
        int notActual = this.b + num.b;
        ComplexNum result = new ComplexNum(actual, notActual);
        return result;     // лучше    return new ComplexNum(a+num.a,b+num.b);


    }

    public ComplexNum sub(ComplexNum num) {
        int actual = this.a - num.a;
        int notActual = this.b - num.b;
        ComplexNum result = new ComplexNum(actual, notActual);
        return result;//        return new ComplexNum(a-num.a,b-num.b);

    }

    public ComplexNum mul(ComplexNum num) {
        int actual = this.a*num.a - this.b*num.b;
        int notActual = this.b * num.a+this.a*num.b;
        ComplexNum  result = new ComplexNum(actual, notActual);
        return result;//  return new ComplexNum(a*num.a-b*num.b,b*num.a+a*num.b);
    }

    public ComplexNum div(ComplexNum num) {
        int actual = (this.a*num.a + this.b*num.b)/(num.a*num.a+num.b*num.b);
        int notActual = (this.b*num.a-this.a*num.b)/(num.a*num.a+num.b*num.b);
        ComplexNum result = new ComplexNum(actual, notActual);
        return result;// return new ComplexNum((a*num.a+b*num.b)/(num.a*num.a + num.b*num.b),(b*num.a-a*num.b)/(num.a*num.a + num.b*num.b));
    }

}
