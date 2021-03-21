package ro.fasttrackit.tema3.ex1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

abstract class PeopleReportGenerator {

    public void generateReport(String outputFile) throws IOException {
        List<People> peoples = readPeoples();
        writeReport(peoples, outputFile);
    }

    private void writeReport(List<People> peoples, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            Map<AgeGroup, List<People>> peoplesGroupByAge = peoples.stream()
                    .collect(groupingBy(People::getAgeGroup));

            for (AgeGroup ageGroup : AgeGroup.values()) {
                writeInLine(writer, ageGroup.getStartAge() + "-" + ageGroup.getEndAge() + ": ");

                if (peoplesGroupByAge.get(ageGroup) != null) {
                    peoplesGroupByAge.get(ageGroup).stream()
                            .map(people -> people.getFirstName() + " " + people.getLastName() + ",")
                            .forEach(line -> writeInLine(writer, line));
                }

                writer.newLine();
            }
        }
    }

    private void writeInLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract List<People> readPeoples();
}
