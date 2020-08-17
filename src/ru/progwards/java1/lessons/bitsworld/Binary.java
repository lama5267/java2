package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;
    public Binary(byte num){
        this.num = num;

    }
        @Override
        public String toString() {
            String result = "";
            result += (num >> 7) & 0b00000001;
            result += (num >> 6) & 0b00000001;
            result += (num >> 5) & 0b00000001;
            result += (num >> 4) & 0b00000001;
            result += (num >> 3) & 0b00000001;
            result += (num >> 2) & 0b00000001;
            result += (num >> 1) & 0b00000001;
            result += (num >> 0) & 0b00000001;
            return result;
        }

    public static void main(String[] args) {
    }
}
