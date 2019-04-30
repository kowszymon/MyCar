package kowszymon.ownProjects.myCar.dao;

import kowszymon.ownProjects.myCar.entities.Income;

import java.util.List;
import java.util.Optional;

public interface IncomeDao {

    List<Income> findAll();

    Optional<Income> findById(Long id);

    void save(Income income);

    void delete(Long id);
}
