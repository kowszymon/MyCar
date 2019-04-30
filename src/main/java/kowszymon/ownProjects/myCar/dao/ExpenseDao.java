package kowszymon.ownProjects.myCar.dao;


import kowszymon.ownProjects.myCar.entities.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseDao {

    List<Expense> findAll();

    Optional<Expense> findById(Long id);

    void save(Expense expense);

    void delete(Long id);
}
