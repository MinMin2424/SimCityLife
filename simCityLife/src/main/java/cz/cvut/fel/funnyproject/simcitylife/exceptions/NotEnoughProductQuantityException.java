package cz.cvut.fel.funnyproject.simcitylife.exceptions;

public class NotEnoughProductQuantityException extends RuntimeException {
    public NotEnoughProductQuantityException(String message) {
        super(message);
    }
}
