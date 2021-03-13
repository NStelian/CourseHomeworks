package ro.fasttrackit.tema2.ex2;

public class TestMain {
    public static void main(String[] args) {
        double mass = 0.6;
        Planet mercury = Planet.MERCURY;
        System.out.println(mercury.getWeightOnEarth(mass));
    }
}
