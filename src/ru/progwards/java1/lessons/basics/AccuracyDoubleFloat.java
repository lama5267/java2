package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

        public static double volumeBallDouble(double radius){
            double x=(4*3.14*radius*radius*radius)/3;
            System.out.println(x);
            return (x);
        }

        public static float volumeBallFloat(float radius) {
            float x = (4f * 3.14f * radius * radius * radius) / 3f;
            System.out.println(x);
            return (x);
        }

        public static double calculateAccuracy(double radius){
            double x=volumeBallDouble(6371.2)-volumeBallFloat(6371.2f);
            System.out.println(x);
            return (x);
        }

        public static void main(String[] args) {
            //volumeBallDouble(1) ;
            //volumeBallFloat(1f) ;
            calculateAccuracy(6371.2f);
        }
    }
