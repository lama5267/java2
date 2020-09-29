package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Profiler {
static TreeMap<String, Instant> tm=new TreeMap<>();
static TreeMap<String, AbstractMap.SimpleEntry<Duration,Integer>>tas=new TreeMap<>();
    static HashMap<String, Set> has= new HashMap<>();

    public static void enterSection(String name) {// - войти в профилировочную секцию, замерить время входа.
var vr=Instant.now();
        tm.put(name,vr);
    }
    public static void exitSection(String name) {// - выйти из профилировочной секции.
        var vr1=Instant.now();
Duration temp=Duration.between(tm.get(name),vr1);
if (tas.containsKey(name)){//если содкржит name то
AbstractMap.SimpleEntry<Duration,Integer>x=new AbstractMap.SimpleEntry<>(tas.get(name));
temp=temp.plus(x.getKey());
tas.put(name,new AbstractMap.SimpleEntry<>(temp,x.getValue()+1));
}else tas.put(name,new AbstractMap.SimpleEntry<>(temp,1));
tm.remove(name);
if (tm.isEmpty()==false){
    Object tt=tm.lastKey();
    String str=String.valueOf(tt);
    if (has.containsKey(str)){
        Set set=new HashSet(has.get(str));
set.add(name);
has.put(str,set);
    } else has.put(str, Set.of(name));
}
    }
    public static List<StatisticInfo> getStatisticInfo(){
        List<StatisticInfo> list=new ArrayList<>();
        Set set=tas.entrySet();
        Iterator<Map> itr=set.iterator();
        while (itr.hasNext()){
            Map.Entry temp=(Map.Entry) itr.next();
            String secName=String.valueOf(temp.getKey());
            AbstractMap.SimpleEntry abstr=(AbstractMap.SimpleEntry) temp.getValue();
            Duration dur=(Duration) abstr.getKey();
            int fultime=(int) dur.toMillis();
            int ful=fultime;
            if (has.containsKey(secName)){
                Iterator<Set> iterator=has.get(secName).iterator();
                while (iterator.hasNext()){
                    String str2=String.valueOf(iterator.next());
                    Map.Entry ent=tas.get(str2);
                    ful=ful-(int) ((Duration) ent.getKey()).toMillis();
                }
            }
            int cnt=(int) abstr.getValue();
            list.add(new StatisticInfo(secName,fultime,ful,cnt));
        }
        list.sort(null);
        return list;
    }
    public static void main(String[] args) {
        enterSection("sec1");
        enterSection("sec2");
        for (int i = 0; i < 1000; i++) {

            int r = 1 + 2;

        }
        exitSection("sec2");
        enterSection("sec3");
        for (int i = 0; i < 1000; i++) {


            for (int j = 0; j < 1000; j++) {
                enterSection("sec4");
                int f = 1 + 2;

                exitSection("sec4");
            }
            enterSection("sec5");
            for (int j = 0; j < 1000; j++) {
                enterSection("secSUB5");
                double m = 0;
                m++;

                exitSection("secSUB5");
            }
            exitSection("sec5");

        }
        exitSection("sec3");
        exitSection("sec1");


        for (StatisticInfo u : getStatisticInfo()) {
            System.out.println(u.toString());

        }

    }

}
