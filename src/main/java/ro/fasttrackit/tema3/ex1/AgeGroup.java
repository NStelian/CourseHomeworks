package ro.fasttrackit.tema3.ex1;

public enum AgeGroup {
    YOUNG(0, 30),
    ADULT(31, 50),
    OLD(51, 100);

    private final int startAge;
    private final int endAge;

    AgeGroup(int startAge, int endAge) {
        this.startAge = startAge;
        this.endAge = endAge;
    }

    public int getStartAge() {
        return startAge;
    }

    public int getEndAge() {
        return endAge;
    }
}
