package ro.fasttrackit.tema3.ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class SubscriptionReportGenerator {
    public void generateReport(String outputFile, List<Subscription> subscriptionsList) throws IOException {
        List<Subscription> subscriptions = subscriptionsList;
        writeReport(subscriptions, outputFile);
    }

    private void writeReport(List<Subscription> subscriptions, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            Map<TimeCategory, List<Subscription>> subscriptionsGroupByAge = subscriptions.stream()
                    .collect(groupingBy(Subscription::getTimeCategory));

            for (TimeCategory timeCategory : TimeCategory.values()) {
                writeInLine(writer, timeCategory + ": ");

                if (subscriptionsGroupByAge.get(timeCategory) != null) {
                    subscriptionsGroupByAge.get(timeCategory).stream()
                            .map(people -> people.getGymMember().getName() + ", ")
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
}
