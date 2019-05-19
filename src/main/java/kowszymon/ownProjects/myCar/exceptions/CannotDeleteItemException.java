package kowszymon.ownProjects.myCar.exceptions;

import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.entities.Expense;

import java.util.ArrayList;
import java.util.List;

public class CannotDeleteItemException extends Exception {

    private Long itemId;

    private List<ExpenseDto> expenses;


    public CannotDeleteItemException(String message) {
        super(message);
    }

    public CannotDeleteItemException(String message, Long ItemId) {
        super(message);
        this.itemId = ItemId;

    }

    public CannotDeleteItemException(String message, List<ExpenseDto> expenses) {
        super(message);
        this.expenses = expenses;

    }


    public Long getItemId() {
        return itemId;
    }

    public List<ExpenseDto> getExpenses() {
        return expenses;
    }
}
