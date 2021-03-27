package ro.fasttrackit.tema4.ex2;

public non-sealed class Chicken implements Bird {
    @Override
    public String sound() {
        return "cucurigu";
    }

    @Override
    public String fly() {
        return "If you pick me up I can fly too";
    }
}
