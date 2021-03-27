package ro.fasttrackit.tema4.ex2;

public class Fly implements Insects{
    @Override
    public String sound() {
        return "bzzz";
    }

    @Override
    public boolean annoyingPeople() {
        return true;
    }
}
