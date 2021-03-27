package ro.fasttrackit.tema4.ex2;

public sealed interface Animal permits Dog, Cat, Bird, Insects {
    String sound();
}

record Cat() implements Animal{
    @Override
    public String sound() {
        return "miau";
    }
}
