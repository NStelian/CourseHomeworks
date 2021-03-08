package ro.fasttrackit.ex3;

public class InsufficientInventoryException extends RuntimeException {
    public InsufficientInventoryException(String errorMessage) {
        super(errorMessage);
    }
}
