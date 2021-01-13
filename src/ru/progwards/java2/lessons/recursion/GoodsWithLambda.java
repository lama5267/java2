package ru.progwards.java2.lessons.recursion;

import java.time.Instant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GoodsWithLambda {
    private List<Goods> goodsList = new ArrayList<>();

    public void setGoods(List<Goods> list) {
        goodsList.addAll(list);
        goodsList.forEach(System.out::println);
    }

    public List<Goods> sortByName() {//вернуть список, отсортированный по наименованию
        goodsList.sort(Comparator.comparing(n -> n.name));
        goodsList.forEach(System.out::println);
        return goodsList;
    }

    public List<Goods> sortByNumber() {// вернуть список, отсортированный по артикулу, без учета регистра
        goodsList.sort(Comparator.comparing(n -> n.number.toLowerCase()));
        goodsList.forEach(System.out::println);
        return goodsList;
    }

    public List<Goods> sortByPartNumber() {//вернуть список, отсортированный по первым 3-м символам артикула, без учета регистра
        goodsList.sort(Comparator.comparing(n -> n.number.substring(0, 2).toLowerCase()));
        goodsList.forEach(System.out::println);
        return goodsList;
    }

    public List<Goods> sortByAvailabilityAndNumber() {//список, отсортированный по количеству, а для одинакового количества, по артикул
        List<Goods> newList = goodsList.stream().sorted(Comparator.comparing(s -> s.number.toLowerCase()))
                .sorted(Comparator.comparing(s -> s.available)).collect(Collectors.toList());
        newList.forEach(System.out::println);
        return newList;
    }

    public List<Goods> expiredAfter(Instant date) {//список, с товаром, который будет просрочен после указанной даты,
        List<Goods> newList = goodsList.stream().filter(s -> s.expired.compareTo(date) > 0)
                .sorted(Comparator.comparing(d -> d.expired)).collect(Collectors.toList());
        newList.forEach(System.out::println);
        return newList;
    }

    public List<Goods> сountLess(int count) {//список, с товаром, количество на складе которого меньше указанного
        List<Goods> newList = goodsList.stream().filter(s -> s.available < count).collect(Collectors.toList());
        newList.forEach(System.out::println);
        return newList;
    }

    public List<Goods> сountBetween(int count1, int count2) {//список, с товаром, количество на складе которого больше count1 и меньше count2,
        List<Goods> newList = goodsList.stream().filter(s -> s.available > count1 && s.available < count2).collect(Collectors.toList());
        newList.forEach(System.out::println);
        return newList;
    }
}
