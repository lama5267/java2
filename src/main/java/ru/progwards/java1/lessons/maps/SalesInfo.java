package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SalesInfo {

    private static String orders;

    public int loadOrders(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        int linesNumber = 0;
        try (FileReader fileReader = new FileReader(fileName);
             Scanner sc = new Scanner(fileReader)) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine().trim();
                String[] fieldsInLine = str.split("\\s*,\\s*");
                if (fieldsInLine.length != 4 || !fieldsInLine[2].matches("\\d+")
                        || !fieldsInLine[3].matches("\\d+(.\\d+)?")) {
                    continue;
                }
                stringBuilder.append(str).append("\n");
                linesNumber++;
            }
            orders = stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesNumber;
    }

    public Map<String, Double> getGoods() {
        Map<String, Double> map = new TreeMap<>();
        try (Scanner sc = new Scanner(orders)) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] fieldsInLine = str.split("\\s*,\\s*");
                String productName = fieldsInLine[1];
                Double cost = Double.valueOf(fieldsInLine[3]);
                if (map.containsKey(productName)) {
                    map.put(productName, map.get(productName) + cost);
                } else {
                    map.put(productName, cost);
                }
            }

        }

        return map;
    }


    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {

        Map<String, AbstractMap.SimpleEntry<Double, Integer>> map = new TreeMap<>();
        try (Scanner sc = new Scanner(orders)) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] fieldsInLine = str.split("\\s*,\\s*");
                String customerName = fieldsInLine[0];
                Integer goodsNumber = Integer.valueOf(fieldsInLine[2]);
                Double cost = Double.valueOf(fieldsInLine[3]);

                if (map.containsKey(customerName)) {
                    AbstractMap.SimpleEntry<Double, Integer> customerData = map.get(customerName);
                    cost = customerData.getKey() + cost;
                    goodsNumber = customerData.getValue() + goodsNumber;
                }

                map.put(customerName, new AbstractMap.SimpleEntry<>(cost, goodsNumber));
            }

        }
        return map;
    }

    public static void main(String[] args) {
        String fileName = "Тест.csv";
        SalesInfo salesInfo = new SalesInfo();
        System.out.println(orders);
        System.out.println(salesInfo.loadOrders(fileName));
        System.out.println(orders);
        System.out.println(salesInfo.getGoods());
        System.out.println(salesInfo.getCustomers());
    }
}
