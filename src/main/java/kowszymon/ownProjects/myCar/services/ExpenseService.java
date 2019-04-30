package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.exceptions.ExpenseNotFoundException;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDto> findExpenses();

    ExpenseDto findExpenseById (Long expenseId) throws ExpenseNotFoundException;

    void save(ExpenseDto expenseDto);

    void delete(Long expenseId);
}
