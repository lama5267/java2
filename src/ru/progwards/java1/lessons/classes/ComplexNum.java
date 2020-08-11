package ru.progwards.java1.lessons.classes;

public class ComplexNum {
   int a;int c;
   int d;
   int b;
    public ComplexNum(int a, int b){
        this.a=a;
        this.b=b;
    }
    public String toString() {
        return Integer.toString(a) + "+ " + Integer.toString(b);
    }
    public ComplexNum sub(ComplexNum num){
return num;    }
    public ComplexNum add(ComplexNum num){
        return num;    }
    public ComplexNum mul(ComplexNum num){
        return num;    }
    public ComplexNum div(ComplexNum num){
        return num;    }
}
