package ro.fasttrackit.tema4.ex2;

public sealed interface Bird extends Animal permits Canary, Parrot, Chicken {
    String fly();
}

record Canary() implements Bird {
    @Override
    public String sound() {
        return "piu";
    }

    @Override
    public String fly() {
        return "flyyy";
    }
}