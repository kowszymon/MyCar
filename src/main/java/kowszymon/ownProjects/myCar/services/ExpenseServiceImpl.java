package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.converters.ExpenseConverter;
import kowszymon.ownProjects.myCar.converters.ExpenseDtoConverter;
import kowszymon.ownProjects.myCar.dao.ExpenseDao;
import kowszymon.ownProjects.myCar.dao.ExpenseDaoImpl;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.entities.Expense;
import kowszymon.ownProjects.myCar.exceptions.ExpenseNotFoundException;
import kowszymon.ownProjects.myCar.exceptions.NotEnoughBudgetException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExpenseServiceImpl implements ExpenseService {

    ExpenseDtoConverter expenseDtoConverter = new ExpenseDtoConverter();

    ExpenseConverter expenseConverter = new ExpenseConverter();

    ExpenseDao expenseDao = new ExpenseDaoImpl();

    BudgetService budgetService;

    @Override
    public List<ExpenseDto> findExpenses() {

        List<Expense> expenses = expenseDao.findAll();

        return expenses.stream().map(expenseDtoConverter).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto findExpenseById(Long expenseId) throws ExpenseNotFoundException {

        Optional<Expense> expenseOptional = expenseDao.findById(expenseId);
        if(expenseOptional.isPresent()) {
            Expense expense = expenseOptional.get();
            ExpenseDto expenseDto = expenseDtoConverter.apply(expense);
            return expenseDto;
        } else {
            throw new ExpenseNotFoundException("Wydatek o id " + expenseId + " nie został znaleziony");
        }

    }

    @Override
    public void save(ExpenseDto expenseDto) throws NotEnoughBudgetException {
        if(budgetService == null){
            budgetService = new BudgetServiceImpl();
        }

        BigDecimal budget = budgetService.budgetCount();

        if (budget.compareTo(expenseDto.getCost()) >= 0) {
            Expense expense = expenseConverter.apply(expenseDto);
            expenseDao.save(expense);
        } else {
            throw new NotEnoughBudgetException("Nie posiadasz wystarczającego budżetu na ten wydatek!");
        }
    }

    @Override
    public void delete(Long expenseId) {
        expenseDao.delete(expenseId);
    }
}
