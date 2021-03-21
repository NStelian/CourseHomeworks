package ro.fasttrackit.tema3.ex3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Gym {
    private final List<Subscription> subscriptions;

    public Gym(List<Subscription> subscriptions) {
        this.subscriptions = new ArrayList<>(subscriptions);
    }

    public List<Subscription> getSubscriptions() {
        return new ArrayList<>(subscriptions);
    }

    public void registerSpentTime(String memberName, LocalTime timeSpent) {
        Optional<Subscription> gymMember = subscriptions.stream()
                .filter(subscription -> subscription.getGymMember().getName().equals(memberName))
                .findFirst();

        gymMember.ifPresent(value -> updateSubscriptionTime(value, timeSpent));
    }

    private void updateSubscriptionTime(Subscription gymMember, LocalTime timeSpent) {
        gymMember.setTime(gymMember.getTime().minusMinutes(timeSpent.getMinute()));
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
