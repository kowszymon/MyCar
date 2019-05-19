package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.IncomeDto;
import kowszymon.ownProjects.myCar.exceptions.CannotDeleteItemException;
import kowszymon.ownProjects.myCar.exceptions.IncomeNotFoundException;

import java.util.List;

public interface IncomeService {

    List<IncomeDto> findIncomes();

    IncomeDto findIncomeById(Long incomeId) throws IncomeNotFoundException;

    void save(IncomeDto incomeDto);

    void delete(Long incomeId);
}
