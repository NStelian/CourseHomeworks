package ro.fasttrackit.tema2.ex3.composition;

import ro.fasttrackit.tema2.ex3.People;

import java.util.List;

public class InMemoryPeopleProvider implements PeopleProvider {
    @Override
    public List<People> readPeoples() {
        return List.of(
                new People("Cipri", "Chise", 22),
                new People("Romeo", "Fantastik", 31)
        );
    }
}
