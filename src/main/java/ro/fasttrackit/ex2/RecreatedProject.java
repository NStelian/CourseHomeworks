package ro.fasttrackit.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

public class RecreatedProject {
    private String name;
    private int price;
    private ArrayList<Category> categories;
    private String description;

    private RecreatedProject() {

    }

    private RecreatedProject(String name, int price, ArrayList<Category> categories, String description) {
        this.name = name;
        this.price = price;
        this.categories = Optional.ofNullable(categories)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecreatedProject project = (RecreatedProject) o;
        return Objects.equals(name, project.name) && Objects.equals(price, project.price) && Objects.equals(categories, project.categories) && Objects.equals(description, project.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, categories, description);
    }

    @Override
    public String toString() {
        return "RecreatedProject{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                '}';
    }

    static class RecreatedProjectBuilder {
        private final RecreatedProject project = new RecreatedProject();

        public static RecreatedProjectBuilder project() {
            return new RecreatedProjectBuilder();
        }

        public RecreatedProjectBuilder name(String name) {
            this.project.name = name;
            return this;
        }

        public RecreatedProjectBuilder price(int price) {
            this.project.price = price;
            return this;
        }

        public RecreatedProjectBuilder categories(Category category) {
            if (this.project.categories == null) {
                this.project.categories = new ArrayList<Category>(Collections.singleton(category));
            } else {
                this.project.categories.add(category);
            }
            return this;
        }

        public RecreatedProjectBuilder description(String description) {
            this.project.description = description;
            return this;
        }

        public RecreatedProject build() {
            return project;
        }
    }
}
