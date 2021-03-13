package ro.fasttrackit.tema1.ex3;

import ro.fasttrackit.tema1.ex2.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Product {
    private final String name;
    private final int price;
    private final List<Category> categories;
    private final String description;
    private int inventoryCount;

    public Product(String name, int price, List<Category> categories, String description, int inventoryCount) {
        this.name = name;
        this.price = price;
        this.categories = Optional.ofNullable(categories)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
        this.description = description;
        this.inventoryCount = inventoryCount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public String getDescription() {
        return description;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && inventoryCount == product.inventoryCount && Objects.equals(name, product.name) && Objects.equals(categories, product.categories) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, categories, description, inventoryCount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                ", inventoryCount=" + inventoryCount +
                '}';
    }
}
