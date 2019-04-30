package kowszymon.ownProjects.myCar.converters;

import kowszymon.ownProjects.myCar.dto.IncomeDto;
import kowszymon.ownProjects.myCar.entities.Income;

import java.math.BigDecimal;
import java.util.function.Function;

public class IncomeDtoConverter implements Function<Income, IncomeDto> {
    @Override
    public IncomeDto apply(Income income) {
        return new IncomeDto(income.getId(), income.getAmount(), income.getDate());
    }
}
