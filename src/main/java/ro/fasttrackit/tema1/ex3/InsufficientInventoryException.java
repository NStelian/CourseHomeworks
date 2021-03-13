package ro.fasttrackit.tema1.ex3;

public class InsufficientInventoryException extends RuntimeException {
    public InsufficientInventoryException(String errorMessage) {
        super(errorMessage);
    }
}
