package ro.fasttrackit.tema3.ex2;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class LogicalSwitch {
    private final Map<Predicate<Person>, Function<Predicate, String>> predicateFunctionMap;

    public LogicalSwitch(Map<Predicate<Person>, Function<Predicate, String>> predicateFunctionMap) {
        this.predicateFunctionMap = predicateFunctionMap;
    }
}
