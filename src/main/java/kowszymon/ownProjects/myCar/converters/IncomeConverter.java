package kowszymon.ownProjects.myCar.converters;

import kowszymon.ownProjects.myCar.dto.IncomeDto;
import kowszymon.ownProjects.myCar.entities.Income;

import java.math.BigDecimal;
import java.util.function.Function;

public class IncomeConverter implements Function<IncomeDto, Income> {

    @Override
    public Income apply(IncomeDto incomeDto) {

        Income income = new Income();

        income.setId(incomeDto.getId());
        income.setDate(incomeDto.getDate());
        income.setAmount(incomeDto.getAmount());


        return income;
    }
}
