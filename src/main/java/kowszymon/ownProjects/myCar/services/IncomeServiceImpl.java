package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.converters.IncomeConverter;
import kowszymon.ownProjects.myCar.converters.IncomeDtoConverter;
import kowszymon.ownProjects.myCar.dao.IncomeDao;
import kowszymon.ownProjects.myCar.dao.IncomeDaoImpl;
import kowszymon.ownProjects.myCar.dto.IncomeDto;
import kowszymon.ownProjects.myCar.entities.Income;
import kowszymon.ownProjects.myCar.exceptions.IncomeNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IncomeServiceImpl implements  IncomeService {

    IncomeDao incomeDao = new IncomeDaoImpl();
    IncomeDtoConverter incomeDtoConverter = new IncomeDtoConverter();
    IncomeConverter incomeConverter = new IncomeConverter();

    @Override
    public List<IncomeDto> findIncomes() {
        List<Income> incomes = incomeDao.findAll();

        return incomes.stream().map(incomeDtoConverter).collect(Collectors.toList());
    }

    @Override
    public IncomeDto findIncomeById(Long incomeId) throws IncomeNotFoundException {
        Optional<Income> incomeOptional = incomeDao.findById(incomeId);

        if(incomeOptional.isPresent()) {
            Income income = incomeOptional.get();
            return incomeDtoConverter.apply(income);
        } else {
            throw new IncomeNotFoundException("Income with id " + incomeId + " could not be found");
        }
    }

    @Override
    public void save(final IncomeDto incomeDto) {
        Income income = incomeConverter.apply(incomeDto);
        incomeDao.save(income);
    }

    @Override
    public void delete(Long incomeId) {
        incomeDao.delete(incomeId);
    }
}
