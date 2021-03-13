package ro.fasttrackit.tema2.ex3.composition;

import ro.fasttrackit.tema2.ex3.People;

import java.util.List;

public interface PeopleProvider {
    List<People> readPeoples();
}
