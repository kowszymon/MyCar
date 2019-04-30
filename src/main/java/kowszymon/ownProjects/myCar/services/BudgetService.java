package kowszymon.ownProjects.myCar.services;

import java.math.BigDecimal;

public interface BudgetService {

    BigDecimal incomesSum();

    BigDecimal expensesSum();

    BigDecimal budgetCount();
}
