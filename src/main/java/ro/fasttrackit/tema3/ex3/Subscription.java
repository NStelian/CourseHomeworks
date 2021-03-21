package ro.fasttrackit.tema3.ex3;

import java.time.LocalTime;
import java.util.Objects;

public class Subscription {
    private final GymMember gymMember;
    private LocalTime time;

    public Subscription(GymMember gymMember) {
        this.gymMember = gymMember;
        this.time = LocalTime.of(30, 0);
    }

    public GymMember getGymMember() {
        return gymMember;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(gymMember, that.gymMember) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymMember, time);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "gymMember=" + gymMember +
                ", time=" + time +
                '}';
    }
}
