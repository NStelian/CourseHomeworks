package ro.fasttrackit.tema2.ex3.composition;

import ro.fasttrackit.tema2.ex3.People;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {
    private final PeopleProvider peopleProvider;

    public ReportGenerator(PeopleProvider peopleProvider) {
        this.peopleProvider = peopleProvider;
    }

    public void generateReport(String outputFile) throws IOException {
        List<People> peoples = peopleProvider.readPeoples();
        writeReport(peoples, outputFile);
    }

    private void writeReport(List<People> peoples, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            printByAge(writer, peoples, 1, 30);
            printByAge(writer, peoples, 30, 50);
            printByAge(writer, peoples, 50, 100);
        }
    }

    private void printByAge(BufferedWriter writer, List<People> peoples, int minAge, int maxAge) throws IOException {
        writeInLine(writer, minAge + "-" + maxAge + ": ");
        peoples.stream()
                .filter(people -> people.getAge() > minAge && people.getAge() <= maxAge)
                .map(people -> people.getFirstName() + " " + people.getLastName() + ",")
                .forEach(line -> writeInLine(writer, line));
        writer.newLine();
    }

    private void writeInLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
