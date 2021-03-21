package ro.fasttrackit.tema3.ex3;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        GymMember gymMember1 = new GymMember("Steli", LocalDate.of(1998, 5, 12));
        GymMember gymMember2 = new GymMember("Cipri", LocalDate.of(1998, 9, 5));

        Subscription subscription1 = new Subscription(gymMember1);
        Subscription subscription2 = new Subscription(gymMember2);

        Gym gym = new Gym(List.of(subscription1, subscription2));

        System.out.println(gym);
        gym.registerSpentTime("Steli", Duration.ofHours(10));
        System.out.println(gym);

        System.out.println(gym.getAverageAge());
        System.out.println(gym.getMinimumAge());
        System.out.println(gym.getMaximumAge());

        System.out.println(gym.getTotalRemainingTimeForAllMembers());

        gym.addTimeToSubscription("Steli", Duration.ofHours(10));
        System.out.println(gym);

        System.out.println(gym.findSubscriptionByName("Steli"));

        SubscriptionReportGenerator subscriptionReportGenerator = new SubscriptionReportGenerator();

        gym.registerSpentTime("Steli", Duration.ofHours(20));
        System.out.println(gym.findSubscriptionByName("Steli"));
        System.out.println(gym);
        subscriptionReportGenerator.generateReport("remaining-time-report-" + LocalDate.now().toString() + ".txt", gym.getSubscriptions());
    }
}
