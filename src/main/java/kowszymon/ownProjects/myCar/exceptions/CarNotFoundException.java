package kowszymon.ownProjects.myCar.exceptions;

import kowszymon.ownProjects.myCar.converters.ExpenseConverter;

public class CarNotFoundException extends Exception {

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
