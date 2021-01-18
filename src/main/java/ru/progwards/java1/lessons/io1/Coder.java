package ru.progwards.java1.lessons.io1;

import java.io.*;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try {
            FileInputStream inStrm = new FileInputStream(inFileName);
            byte[] inBytes = inStrm.readAllBytes();
            char[] outChar = new char[inBytes.length];
            for (int i = 0; i < inBytes.length; i++) {
                outChar[i] = code[(int)((char)inBytes[i])];

            }
            inStrm.close();
            FileWriter outStrm = new FileWriter(outFileName);
            outStrm.write(outChar);
            outStrm.close();

        } catch (Exception e) {
            try {
                FileWriter logFile = new FileWriter(logName, true);
                try {
                    logFile.write(e.getMessage() + "\n");
                } finally {
                    logFile.close();
                }
                e.printStackTrace();
            } catch (IOException ioException) {
                System.out.println("log err");;
            }


        }

    }

}

