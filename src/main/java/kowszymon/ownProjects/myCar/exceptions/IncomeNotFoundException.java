package kowszymon.ownProjects.myCar.exceptions;

public class IncomeNotFoundException extends Exception {

    public IncomeNotFoundException(String message) {
        super(message);
    }

    public IncomeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
