package cz.cvut.fel.funnyproject.simcitylife.exceptions;

public class ShoppingBagNotContainsProductException extends RuntimeException {
    public ShoppingBagNotContainsProductException(String message) {
        super(message);
    }
}
