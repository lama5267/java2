package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone) throws Exception {
StringBuilder telefon=new StringBuilder();
try {
    for (char x: phone.toCharArray())          //проверка на символы

        if (Character.isDigit(x)){
            telefon.append(x);
        }
    if (telefon.length()>11) throw new Exception();        //если больше 11 цифр выбрасываем исключение

    if (telefon.charAt(0) == '8'){                  //если  первая цифра 8
        telefon.replace(0,1,"7");   //меняем на  7
    }
    telefon.insert(0,'+');        //втавляем символы в индексы
    telefon.insert(2,'(');        //по шаблону +7(999)111-2233
    telefon.insert(6,')');
    telefon.insert(10,'-');

}catch (Exception e){
    throw  e;
}
return telefon.toString();
    }
public static void main(String[] args) {
    try {
        System.out.println(format("8 999 111-22-33"));
    } catch (Exception exception) {
        exception.printStackTrace();
    }
}
}

