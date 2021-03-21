package ro.fasttrackit.tema3.ex3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Gym {
    private final List<Subscription> subscriptions;

    public Gym(List<Subscription> subscriptions) {
        this.subscriptions = new ArrayList<>(subscriptions);
    }

    public List<Subscription> getSubscriptions() {
        return new ArrayList<>(subscriptions);
    }

    public void registerSpentTime(String memberName, Duration timeSpent) {
        Subscription subscription = findSubscriptionByName(memberName);
        Duration currentTime = subscription.getExpireDate().minus(timeSpent);
        subscription.setExpireDate(currentTime);
    }

    public void addTimeToSubscription(String memberName, Duration timeToBeAdd) {
        Subscription subscription = findSubscriptionByName(memberName);
        Duration currentTime = subscription.getExpireDate().plus(timeToBeAdd);
        subscription.setExpireDate(currentTime);
    }

    public Subscription findSubscriptionByName(String memberName) {
        return subscriptions.stream()
                .filter(subscription -> subscription.getGymMember().getName().equals(memberName))
                .findFirst()
                .orElse(new Subscription());
    }

    public int getMaximumAge() {
        return getMembersAges().stream()
                .max(Integer::compare)
                .get();
    }

    public int getMinimumAge() {
        return getMembersAges().stream()
                .min(Integer::compare)
                .get();
    }

    public double getAverageAge() {
        return getMembersAges().stream()
                .mapToDouble(age -> age)
                .average()
                .orElse(Double.NaN);
    }

    public long getTotalRemainingTimeForAllMembers() {
        return subscriptions.stream()
                .mapToLong(subscription -> subscription.getExpireDate().toHours())
                .sum();
    }

    private void reduceSubscriptionTime(Subscription gymMember, Duration timeSpent) {
        Duration currentTime = gymMember.getExpireDate().minus(timeSpent);
        gymMember.setExpireDate(currentTime);
    }

    private List<Integer> getMembersAges() {
        LocalDate todayDate = LocalDate.now();

        return this.subscriptions.stream()
                .map(subscription -> Period.between(subscription.getGymMember().getBirthdate(), todayDate).getYears())
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gym gym = (Gym) o;
        return Objects.equals(subscriptions, gym.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptions);
    }

    @Override
    public String toString() {
        return "Gym{" +
                "subscriptions=" + subscriptions +
                '}';
    }
}
