package ro.fasttrackit.tema3.ex3;

import java.time.Duration;
import java.util.Objects;

public class Subscription {
    private GymMember gymMember;
    private Duration expireDate;
    private TimeCategory timeCategory;

    public Subscription() {
    }

    public Subscription(GymMember gymMember) {
        this.gymMember = gymMember;
        this.expireDate = Duration.ofHours(30);
        changeTimeCategory();
    }

    public GymMember getGymMember() {
        return gymMember;
    }

    public Duration getExpireDate() {
        return expireDate;
    }

    public TimeCategory getTimeCategory() {
        return timeCategory;
    }

    public void setExpireDate(Duration expireDate) {
        this.expireDate = expireDate;
        changeTimeCategory();
    }

    private void changeTimeCategory() {
        if (this.expireDate.toHours() < 10) {
            this.timeCategory = TimeCategory.RED;
        } else if (this.expireDate.toHours() < 30) {
            this.timeCategory = TimeCategory.YELLOW;
        } else {
            this.timeCategory = TimeCategory.GREEN;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(gymMember, that.gymMember) && Objects.equals(expireDate, that.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymMember, expireDate);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "gymMember=" + gymMember +
                ", time=" + expireDate +
                '}';
    }
}
