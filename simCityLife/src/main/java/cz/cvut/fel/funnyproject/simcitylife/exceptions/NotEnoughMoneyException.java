package cz.cvut.fel.funnyproject.simcitylife.exceptions;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
