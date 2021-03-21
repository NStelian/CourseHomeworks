package ro.fasttrackit.tema3.ex1;

import java.util.List;

public class InMemoryPeopleReportGenerator extends PeopleReportGenerator {
    @Override
    protected List<People> readPeoples() {
        return List.of(
                new People("Steli", "Nitu", 22),
                new People("Romeo", "Fantastik", 31)
        );
    }
}
