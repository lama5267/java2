package ru.progwards.java1.lessons.bigints;

abstract public class AbsInteger {
    private static AbsInteger num1;
    private static AbsInteger num2;


    static AbsInteger   add(AbsInteger num1, AbsInteger num2) {
   return AbsInteger.num1;
    }



    class ByteInteger extends AbsInteger {
        byte num;

        public ByteInteger(byte num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "ByteInteger{" +
                    "num=" + num +
                    '}';
        }
        public byte anByteGetNum(int num) {
            return (byte) num;
        }
    }
    class ShortInteger extends AbsInteger {
        short  num;

        public ShortInteger(short  num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "ShortInteger{" +
                    "num=" + num +
                    '}';
        }
        public short anShortGetNum(int num) {
            return (short) num;
        }
    }


    class IntInteger extends AbsInteger {
        int num;

        public IntInteger(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "IntInteger{" +
                    "num=" + num +
                    '}';
        }
        public int anIntGetNum(int num) {
            return (int) num;
        }

    }
}

