package ro.fasttrackit.tema4.ex2;

public non-sealed interface Insects extends Animal {
    boolean annoyingPeople();
}

record LadyBug() implements Insects {
    @Override
    public String sound() {
        return "vrum";
    }

    @Override
    public boolean annoyingPeople() {
        return false;
    }
}
