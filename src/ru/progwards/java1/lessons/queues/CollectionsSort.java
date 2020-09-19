package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {
    public static void mySort(Collection<Integer> data){
        List<Integer> list = new ArrayList<>(data);
        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){
                if(list.get(j) < list.get(i)){
                    Integer x = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, x);
                }
            }
        }
        data.clear();
        data.addAll(list);
    }

    public static void minSort(Collection<Integer> data){
        List<Integer> novcol = new LinkedList();//новая коллекция
while (!data.isEmpty()){        // пока коллекция не станет пустой
    Integer min = Collections.min(data);        //определяем минимальное значение в колекции data
data.remove(min);//удаляем минимальный
novcol.add(min);//добавляем минимальный элемент в нову коллекцию
}
data.clear();//отчищаем коллекцию
data.addAll(novcol);//добавляем все элементы
    }
    static void collSort(Collection<Integer> data){
        Collections.sort((List) data);
    }

    static class CompMetod {
        String name;
        long time;

        public CompMetod(String name, long time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public long getTime() {
            return time;
        }

        public void setName(String name) {
            this.name = name;
        }

        static class TimeComparator implements Comparator<CompMetod> {
            @Override
            public int compare(CompMetod o1, CompMetod o2) {
                return Long.compare(o1.getTime(), o2.getTime());
            }
        }

        static class NameComparator implements Comparator<CompMetod> {
            @Override
            public int compare(CompMetod o1, CompMetod o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
    }

    public static Collection<String> compareSort() {

        ArrayList<String> arrayList = new ArrayList<>();    //  для возврата
        Collection<Integer> list1 = fillFull(1_000);
        Collections.shuffle((List<?>) list1);


        Comparator<CompMetod> metСomp = new CompMetod.TimeComparator().thenComparing(new CompMetod.NameComparator());
        TreeSet<CompMetod> metСoll = new TreeSet<CompMetod>(metСomp);

        long start0 = System.currentTimeMillis();
        mySort(list1);
        long start1 = System.currentTimeMillis();
        metСoll.add(new CompMetod("mySort", start1 - start0));

        start0 = System.currentTimeMillis();
        minSort(list1);
        start1 = System.currentTimeMillis();
        metСoll.add(new CompMetod("minSort", start1 - start0));

        start0 = System.currentTimeMillis();
        collSort(list1);
        start1 = System.currentTimeMillis();
        metСoll.add(new CompMetod("collSort", start1 - start0));

        for (CompMetod mets : metСoll) {
            arrayList.add(mets.getName());
        }
        System.out.println(arrayList);
        return arrayList;
    }

    private static Collection<Integer> fillFull(int i) {
        final Collection<Integer> test = new ArrayList<>();
        for (int j = 0; j < i; j++) test.add((int) (Math.random() * 100));
        return test;
    }
    public static void main(String[] args) {
        Collection<Integer> cal = new ArrayList<>();

        cal.add(37);
        cal.add(52);
        cal.add(02);
        cal.add(77);
        cal.add(49);
        cal.add(34);


        collSort(cal);
        System.out.println("       coll               =" + cal);


        for (int i = 0; i < 6; i++) {
            System.out.println(compareSort());
        }


    }
}
