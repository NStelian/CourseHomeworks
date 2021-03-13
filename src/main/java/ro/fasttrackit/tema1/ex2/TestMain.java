package ro.fasttrackit.tema1.ex2;

import static ro.fasttrackit.tema1.ex2.Project.ProjectBuilder.project;

public class TestMain {
    public static void main(String[] args) {
        Project project = project()
                .name("project1")
                .price(123)
                .categories(Category.FOOD)
                .categories(Category.CLOTHES)
                .description("description")
                .build();

        System.out.println(project);
    }
}
