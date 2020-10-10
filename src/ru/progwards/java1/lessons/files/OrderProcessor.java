package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


public class OrderProcessor {
    String pathMain;
    LocalDate time;
    int count = 0;
    List<Order> ordersLL = new ArrayList<>();


    public OrderProcessor(String startPath) {//- инициализирует класс, с указанием начальной папки для хранения файлов
        this.pathMain = startPath;
    }
    public int loadOrders(LocalDate start, LocalDate finish, String shopId){
     //- загружает заказы за указанный диапазон дат
        if (shopId == null) shopId = "???";
        if (start == null) start = LocalDate.of(2008, 12, 03);
        if (finish == null) finish = LocalDate.of(3000, 12, 12);
        String pathStr = "glob:**/" + shopId + "-??????-????.csv";
        PathMatcher pathMatcher= FileSystems.getDefault().getPathMatcher(pathStr);
        System.out.println("pathMathcer:" + pathStr + "          pathMain:" + pathMain + "                  shopId" + shopId);
try {
    LocalDate finalStart = start;
    LocalDate finalFinish = finish;
    Files.walkFileTree(Paths.get(pathMain), new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
            Instant instTime;
            if (pathMatcher.matches(Paths.get(pathMain).relativize(path))) {
                try {
                    System.out.println("path:" + path);
                    instTime = Files.getLastModifiedTime(path).toInstant();
                    time=LocalDate.ofInstant(instTime, ZoneId.systemDefault());
                    System.out.println("time:" + time);
                    if (time.isAfter(finalStart) && time.isBefore(finalFinish) || time.equals(finalStart) || time.equals(finalFinish)) {
                        Order temp = extractor(path, instTime);
                        if (temp != null) ordersLL.add(temp);
                        else count++;
                    }
                } catch (IOException e) {

                    System.out.println("instan time");
                    //e.printStackTrace();
                }


            }
            System.out.println("выход из удачного волкера");
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException e) {
            // count++;
            System.out.println("выход из НЕудачного волкера");
            return FileVisitResult.CONTINUE;
        }


    });
} catch (IOException e) {
    System.out.println("Walker --");
    // e.printStackTrace();
}
       /* pathMain = null;
        time = null;*/

        System.out.println("КОНЕЦ волкера");
        return count;
    }
    static Order extractor(Path pth, Instant tim) {
        System.out.println("ЭКСТРАКТОР" + "   pth:" + pth + "    tim:" + tim);
        Order ord = new Order();
        List<OrderItem> lItm = new LinkedList<>();
        List<String> lString = null;

        String nameFile = pth.getFileName().toString();
        System.out.println("парсинг названия :" + nameFile);
        ord.setShopId(nameFile.substring(0, 3));

        ord.setOrderId(nameFile.substring(4, 10));

        ord.setCustomerId(nameFile.substring(11, 15));
        ord.setDatetime(LocalDateTime.ofInstant(tim, ZoneId.systemDefault()));
        System.out.println(" перед файла в строку");
        try {
            lString = Files.readAllLines(pth);



        } catch (IOException e) {
            System.out.println("@@@@@@@@@           extractor error");
        }
        System.out.println(" перед итератором");
        Iterator<String> iter = lString.iterator();
        System.out.println("0");
        while (iter.hasNext()) {
            System.out.println("1");
            OrderItem temp = new OrderItem();
            System.out.println("2");
            Scanner scan = new Scanner(iter.next());
            System.out.println("3");
            scan.useDelimiter("\\s*,\\s*");
            System.out.println("4");
            if (scan.hasNext()) temp.setGoogsName(scan.next());
            else {
                scan.close();//закрывает открытый сканер
                return null;
            }

            System.out.println("5");
            if (scan.hasNextInt()) temp.setCount(Integer.parseInt(scan.next()));
            else {
                scan.close();//закрывает открытый сканер
                return null;
            }

            System.out.println("6");
            if (scan.hasNextDouble()) temp.setPrice(Double.parseDouble(scan.next()));
            else {
                scan.close();//закрывает открытый сканер
                return null;
            }

            System.out.println("******** OredrItem:" + temp);

            lItm.add(temp);
            scan.close();//закрывает открытый сканер

        }
        System.out.println("после итератора");
        lItm.sort(null);
        ord.setItems(lItm);
        ord.setSum();
        System.out.println("**********************  ENd  *****************************");
        return ord;

    }
    public List<Order> process(String shopId) {
        //- выдать список заказов в порядке обработки (отсортированные по дате-времени),
        List<Order> res = new ArrayList<>();
        Comparator dateComparator = new Comparator<Order>() {

            @Override
            public int compare(Order o1, Order o2) {
                return o1.getDatetime().compareTo(o2.getDatetime());
            }
        };
        for (Order order:ordersLL){
            if (shopId == null) res.add(order);
            if (shopId != null && shopId.equals(order.getShopId())) res.add(order);
        }
        res.sort(dateComparator);
        return res;
    }
    public Map<String, Double> statisticsByShop() {
        //- выдать информацию по объему продаж по магазинам (отсортированную по ключам):
        Map<String, Double> res = new TreeMap<>();
        for (Order order : ordersLL) {
            if (res.containsKey(order.getShopId())) {
                double ts = res.get(order.getShopId()) + order.getSum();
                res.put(order.getShopId(), ts);
            } else {
                res.put(order.getShopId(), order.getSum());
            }
        }
        return res;
    }
    public Map<String, Double> statisticsByGoods() {
        //- выдать информацию по объему продаж по товарам (отсортированную по ключам)
        Map<String, Double> res = new TreeMap<>();
        for (Order order : ordersLL) {

            for (OrderItem ordItem : order.getItems()) {
                if (res.containsKey(ordItem.getGoogsName())) {
                    double gs = res.get(ordItem.getGoogsName()) + ordItem.getPrice() * ordItem.getCount();
                    res.put(ordItem.getGoogsName(), gs);
                } else {
                    res.put(ordItem.getGoogsName(), ordItem.getPrice() * ordItem.getCount());
                }
            }
        }
        return res;
    }
    public Map<LocalDate, Double> statisticsByDay() {
        //- выдать информацию по объему продаж по дням (отсортированную по ключам)
        Map<LocalDate, Double> res = new TreeMap<>();
        for (Order order : ordersLL) {
            LocalDate ld = (order.getDatetime()).toLocalDate();
            if (res.containsKey(ld)) {
                double ds = res.get(ld) + order.getSum();
                res.put(ld, ds);
            } else {
                res.put(ld, order.getSum());
            }
        }
        return res;
    }
}
