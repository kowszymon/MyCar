package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.exceptions.ExpenseNotFoundException;
import kowszymon.ownProjects.myCar.exceptions.NotEnoughBudgetException;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDto> findExpenses();

    ExpenseDto findExpenseById (Long expenseId) throws ExpenseNotFoundException;

    void save(ExpenseDto expenseDto) throws NotEnoughBudgetException;

    void delete(Long expenseId);
}
