package ro.fasttrackit.tema3.ex1;

import java.util.Objects;

public class People {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final AgeGroup ageGroup;

    public People(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ageGroup = checkAgeGroup();
    }

    private AgeGroup checkAgeGroup() {
        for (AgeGroup ageGroup : AgeGroup.values()) {
            if (getAge() > ageGroup.getStartAge() && getAge() <= ageGroup.getEndAge()) {
                return ageGroup;
            }
        }

        return AgeGroup.YOUNG;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age && Objects.equals(firstName, people.firstName) && Objects.equals(lastName, people.lastName) && ageGroup == people.ageGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, ageGroup);
    }

    @Override
    public String toString() {
        return "People{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", ageGroup=" + ageGroup +
                '}';
    }
}
