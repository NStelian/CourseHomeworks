package ro.fasttrackit.tema1.ex3;


import ro.fasttrackit.tema1.ex2.Category;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        Product product = new Product("product1", 1234, List.of(Category.FOOD), "description2", 10);

        Product product2 = new Product("product1", 1234, List.of(Category.FOOD), "description2", 10);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);

        Shop shop = new Shop(products);
        System.out.println(shop);

        shop.addProductToInventory(product);

        Product product3 = new Product("product3", 1234, List.of(Category.FOOD), "description2", 10);

        shop.addProductToInventory(product3);
        System.out.println(shop);

        shop.buyProduct(product, 9);
        System.out.println(shop);
        shop.buyProduct(product, 11);
    }
}
