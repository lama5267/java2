package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class LettersInFile  {
    public static String process(String fileName) throws IOException {
        String str = "";
        TreeSet<Character> temp = new TreeSet<>();//множество Character
        try(FileReader reader = new FileReader(fileName)){//прочитываем файл
            Scanner scann = new Scanner(reader);//прочитаем при помощи сканера
            while(scann.hasNext()){
                String str1 = scann.nextLine();
                char[] charStr = str1.toCharArray();
                for(int i = 0; i < charStr.length; i++){
                    temp.add(charStr[i]);
                }
            }
        }
        for(Character s:temp)
            if(Character.isLetter(s))//  если  символ буква то
                str += s;
        return str;
    }
    public static void main(String[] args) throws IOException {
        String process;
        process = LettersInFile.process("file1.txt");
        System.out.println(process);
    }
}
