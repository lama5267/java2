package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductAnalytics {
    private List<Shop> shops;// - список магазинов
    private List<Product> products;// - список всех имеющихся в ассортименте товаров

    public ProductAnalytics(List<Product> products,List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }
    public Set<Product> existInAll(){//- товары из products,  которые имеются во всех магазинах
        Set<Product> set=new HashSet<>(products);
        for (int i=0;i< shops.size();i++){
        set.retainAll(shops.get(i).getProducts());//оставляем только имеющиеся
        }
        return set;
    }
    public Set<Product> existAtListInOne(){    //- товары из products, которые имеются хотя бы в одном магазине
        Set<Product> set = new HashSet<>(shops.get(0).getProducts());
        for (int i=0;i< shops.size();i++){
            set.addAll(shops.get(i).getProducts());//добавляем все
        }
        return set;
    }
    public Set<Product> notExistInShops(){//- товары из products,  которых нет ни в одном магазине
        Set<Product> set=new HashSet<>(products);
        for (int i=0;i< shops.size();i++){
            set.removeAll(shops.get(i).getProducts());//удаляем все лишние
        }
        return set;
    }
    public Set<Product> existOnlyInOne(){
//- товары из products,  которые есть только в одном магазине
            Set<Product> set = new HashSet<>();
//цикл по всем продуктам
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                int n = 0;
//по всем магазинам
                for (int j = 0; j < shops.size(); j++) {
                    if (shops.get(j).getProducts().contains(p))
                        n++;
                }
//добавлять если уникальный
                if (n == 1)
                    set.add(p);
            }
            return set;
        }

        public static void main(String[] args) {
            List<Product> produc = new ArrayList<>();
            produc.add(new Product("1"));
            produc.add(new Product("3"));
            produc.add(new Product("5"));
            produc.add(new Product("8"));
            produc.add(new Product("2"));

            List<Product> pr1 = new ArrayList<>();
            pr1.add(new Product("1"));
            pr1.add(new Product("2"));
            pr1.add(new Product("3"));
            Shop shop1 = new Shop(pr1);

            List<Product> pr2 = new ArrayList<>();
            pr2.add(new Product("5"));
            pr2.add(new Product("2"));
            pr2.add(new Product("3"));
            Shop shop2 = new Shop(pr2);

            List<Shop> shops = new ArrayList<>();
            shops.add(shop1);
            shops.add(shop2);

            ProductAnalytics prod = new ProductAnalytics(produc, shops);
            System.out.println("existsinall: " + prod.existInAll().size());
            System.out.println("existinone : " + prod.existAtListInOne().size());
            System.out.println("not exist  : " + prod.notExistInShops().size());
            System.out.println("exist only : " + prod.existOnlyInOne().size());

        }
    }



