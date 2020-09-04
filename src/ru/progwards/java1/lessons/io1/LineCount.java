package ru.progwards.java1.lessons.io1;


import java.io.FileReader;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
    int x=0;//подсчет строк
    try {
        FileReader reader=new FileReader(fileName);
        Scanner scanner=new Scanner(reader);
        while (scanner.hasNextLine()){
            String strFromFile=scanner.nextLine();
            if (strFromFile.length()==0)x++;//подсчет пустых строк
        }
        reader.close();
          } catch (Exception e) {
        return -1;
    }
return x;
    }

    public static void main(String[] args) {
        System.out.println(calcEmpty("file1.txt"));
    }
}
