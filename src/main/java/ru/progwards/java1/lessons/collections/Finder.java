package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers)  {
        List<Integer> colsum= new ArrayList<>();//коллекция сложеных соседних чисел
        List<Integer> list = (List<Integer>) numbers; //существующая коллекция
for (int i=0;i<numbers.size()-1;i++){//наполняем колекцию colsum сложенными соседними числами
    colsum.add(list.get(i) + list.get(i+1));//складываем два ближайщих числа
}
        Integer min = Collections.min(colsum);        //определяем минимальное значение в колекции сум
        List<Integer> mincol= new ArrayList<>();//коллекция индексов чисел сумма которых минимальная
        for (int x=0;x<numbers.size()-1;x++){
if (list.get(x) + list.get(x+1)==min){//складываем два минимальных ближайших числа
    mincol.add(x);
    mincol.add(x+1);
}
    }

return mincol;
    }
    public static Collection<Integer> findLocalMax(Collection<Integer> numbers){
        List<Integer> maxcol= new ArrayList<>();//коллекция максимальных  чисел
        List<Integer> list = (List<Integer>) numbers; //существующая коллекция
        for (int i=1;i < list.size()-1;i++){
if (list.get(i)>list.get(i-1)&&list.get(i)>list.get(i+1)){//число болше соседа справа и слева
    maxcol.add(list.get(i));
}
        }
        return maxcol;
    }
    public static boolean findSequence(Collection<Integer> numbers) {
        ArrayList<Integer> arl = new ArrayList<>(numbers);
        for (int i = 1; i <= numbers.size(); i++) {
            arl.add(i);
        }

        return numbers.containsAll(arl);//содержит ли коллекция все числа
    }
    public static String findSimilar(Collection<String> names){

        List<String> nameListStr = new LinkedList();
        nameListStr.add("name");
        nameListStr.add("1");

    List<String> strList = (List<String>) names; //существующая коллекция
        for (int i=0; i<strList.size(); i++){
        String name = strList.get(i); //слово
        int coutName = 0; //считает количество рядом стоящих слов
        for (int j=i; j<strList.size(); j++){
            if(strList.get(i).equals(strList.get(j)) == true){
                coutName += 1;//если следующее слово одинаково то увеличиваем счет на 1
            } else {
                break;
            }
        }

        if(coutName > Integer.parseInt(nameListStr.get(1))){//если счет слов больше чем цифра в колекции
            //то мы перезаписываем счет и слово
            nameListStr.set(0,name);//слово
            nameListStr.set(1,String.valueOf(coutName));//счет првращаем в строку
        }

    }
        return nameListStr.get(0) + ":" + nameListStr.get(1);
}
    public static void main(String[] args) {
        List<String> arrayListStr = new LinkedList();

        arrayListStr.add("Макс");
        arrayListStr.add("Макс");
        arrayListStr.add("Коля");
        arrayListStr.add("Паша");
        arrayListStr.add("Лиза");
        List<Integer> arrayList2 = new LinkedList();

        arrayList2.add(1);
        arrayList2.add(2);
        List<Integer> arrayList = new LinkedList();
        arrayList.add(5);
        arrayList.add(33);
        arrayList.add(55);
        arrayList.add(34);
        arrayList.add(22);
        System.out.println(arrayList);
        System.out.println(findLocalMax(arrayList));

        System.out.println(findSequence(arrayList));

        System.out.println(findMinSumPair(arrayList));

        System.out.println(arrayListStr);

        System.out.println(findSimilar(arrayListStr));
    }
}


