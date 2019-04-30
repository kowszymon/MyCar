package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.dto.IncomeDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BudgetServiceImpl implements BudgetService {

    IncomeService incomeService = new IncomeServiceImpl();

    ExpenseService expenseService = new ExpenseServiceImpl();

    @Override
    public BigDecimal incomesSum() {

        List<IncomeDto> incomes = incomeService.findIncomes();

        BigDecimal incomesSum = BigDecimal.ZERO;

        if (!incomes.isEmpty()) {
            for (IncomeDto income : incomes) {
                incomesSum = incomesSum.add(income.getAmount());
            }
        }

        return incomesSum;

    }

    @Override
    public BigDecimal expensesSum() {

        List<ExpenseDto> expenses = expenseService.findExpenses();

        BigDecimal expensesSum = BigDecimal.ZERO;

        if (expenses.isEmpty()) {
            return expensesSum;
        } else {
            for (ExpenseDto expense : expenses) {
                expensesSum = expensesSum.add(expense.getCost());
            }
        }

        return expensesSum;
    }

    @Override
    public BigDecimal budgetCount() {
        return null;
    }
}
