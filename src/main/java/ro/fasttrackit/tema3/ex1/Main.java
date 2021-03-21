package ro.fasttrackit.tema3.ex1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var generator = new FilePeopleReportGenerator("src/main/resources/people.txt");
        generator.generateReport("from-file-peoples.txt");

        new InMemoryPeopleReportGenerator().generateReport("in-memory-people.txt");
    }
}
