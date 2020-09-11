package ru.progwards.java1.lessons.io2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Censor {
    //свой класс метод исключения
    public static class CensorException extends IOException {
        private String fileName;
        private String message;
        public CensorException(){}
        public CensorException(String fileName){
            super();
            this.fileName = fileName;
            this.message = super.getMessage();
        }

        @Override
        public String toString(){
            return fileName+":"+ message;
        }
    }
    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {

        try (RandomAccessFile files = new RandomAccessFile(inoutFileName, "rw")) {
            String str = files.readLine(); //читаем строку файла
            for (int i = 0; i < obscene.length; i++) {
                String replace = obscene[i]; //слово которое надо заменить в строке
                String nevReplace = "";
                for (int j = 0; j < replace.length(); j++) {//создаем строку из * длиной требуемого на замену слова
                    nevReplace = nevReplace + "*";
                }
                str = str.replace(replace, nevReplace);//делаем замену в строке которую достали из файла


            }
            files.seek(0);//поставим курсор в начало файла

            files.writeBytes(str);//записываем строку вместо той что была в файле

            files.close();//закрываем файл
        } catch (Exception e) {
            /* В случае возникновения ошибки, выбросить свое собственное исключение CensorException в
            котором сохранить - строку, полученную у оригинального exception через метод getMessage() и имя файла,
            в котором возникла ошибка. В классе перекрыть метод toString(), вернув <имя файла>:<строка ошибки>.
             Класс CensorException разместить в классе Censor*/
            throw new CensorException(inoutFileName);
        }

    }
    public static void main(String[] args) {
        String[] obscene = {"Java", "Oracle", "Sun", "Microsystems","Test"};
        try {
            censorFile("file1.txt", obscene);
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }

    }
}
