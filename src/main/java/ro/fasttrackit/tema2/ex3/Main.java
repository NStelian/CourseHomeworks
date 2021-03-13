package ro.fasttrackit.tema2.ex3;

import ro.fasttrackit.tema2.ex3.composition.FilePeopleReportProvider;
import ro.fasttrackit.tema2.ex3.composition.InMemoryPeopleProvider;
import ro.fasttrackit.tema2.ex3.composition.ReportGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var generator = new FilePeopleReportGenerator("src/main/resources/people.txt");
        generator.generateReport("from-file-peoples.txt");

        new InMemoryPeopleReportGenerator().generateReport("in-memory-people.txt");

        FilePeopleReportProvider fileProvider = new FilePeopleReportProvider("src/main/resources/people.txt");
        new ReportGenerator(fileProvider).generateReport("from-file-peoples2.txt");

        InMemoryPeopleProvider inMemoryProvider = new InMemoryPeopleProvider();
        new ReportGenerator(inMemoryProvider).generateReport("in-memory-people2.txt");
    }
}
