package ro.fasttrackit.ex2;

import java.util.*;

public class Project {
    private final String name;
    private final int price;
    private final List<Category> categories;
    private final String description;

    private Project(String name, int price, List<Category> categories, String description) {
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

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(price, project.price) && Objects.equals(categories, project.categories) && Objects.equals(description, project.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, categories, description);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                '}';
    }

    static class ProjectBuilder {
        private String name;
        private int price;
        private List<Category> categories;
        private String description;

        public static ProjectBuilder project() {
            return new ProjectBuilder();
        }

        public ProjectBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProjectBuilder price(int price) {
            this.price = price;
            return this;
        }

        public ProjectBuilder categories(Category category) {
            if (this.categories == null) {
                this.categories = new ArrayList<>(Collections.singleton(category));
            } else {
                this.categories.add(category);
            }
            return this;
        }

        public ProjectBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Project build() {
            return new Project(name, price, categories, description);
        }
    }
}
