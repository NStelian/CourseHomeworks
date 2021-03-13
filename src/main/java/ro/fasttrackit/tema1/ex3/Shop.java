package ro.fasttrackit.tema1.ex3;

import java.util.ArrayList;
import java.util.Objects;

public class Shop {
    private final ArrayList<Product> products;

    public Shop(ArrayList<Product> products) {
        this.products = uniqueNameValidator(products);
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProductToInventory(Product product) {
        if (uniqueNameChecker(product)) {
            this.products.add(product);
        } else {
            this.products.forEach(prod -> {
                if (prod.getName().equals(product.getName())) {
                    product.setInventoryCount(prod.getInventoryCount() + product.getInventoryCount());
                    updateInventoryCount(product);
                }
            });
        }
    }

    public void buyProduct(Product product, int amount) {
        if (product.getInventoryCount() > amount) {
            product.setInventoryCount(product.getInventoryCount() - amount);
            updateInventoryCount(product);
        } else {
            throw new InsufficientInventoryException("This product doesn't have enough stock");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(products, shop.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }

    private void updateInventoryCount(Product product) {
        this.products.forEach(prod -> {
            if (prod.getName().equals(product.getName())) {
                prod.setInventoryCount(product.getInventoryCount());
            }
        });
    }

    private ArrayList<Product> uniqueNameValidator(ArrayList<Product> products) {
        ArrayList<Product> uniqueProducts = new ArrayList<>();

        products.forEach(product -> {
            if (uniqueProducts.stream().noneMatch(value -> value.getName().equals(product.getName()))) {
                uniqueProducts.add(product);
            }
        });

        return uniqueProducts;
    }

    private boolean uniqueNameChecker(Product product) {
        return this.products.stream()
                .noneMatch(value -> value.getName().equals(product.getName()));
    }
}
