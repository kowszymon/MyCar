package kowszymon.ownProjects.myCar.exceptions;

public class NotEnoughBudgetException extends Exception {

    public NotEnoughBudgetException(String message) {
        super(message);
    }

    public NotEnoughBudgetException(String message, Throwable cause) {
        super(message, cause);
    }
}
