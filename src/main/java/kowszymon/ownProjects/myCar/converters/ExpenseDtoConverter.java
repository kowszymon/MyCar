package kowszymon.ownProjects.myCar.converters;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.entities.Car;
import kowszymon.ownProjects.myCar.entities.Category;
import kowszymon.ownProjects.myCar.entities.Expense;

import java.util.function.Function;

public class ExpenseDtoConverter implements Function<Expense, ExpenseDto> {

    private Function<Car, CarDto> carDtoConverter;

    private Function<Category, CategoryDto> categoryDtoConverter;

    @Override
    public ExpenseDto apply(Expense expense) {

        if(carDtoConverter == null) {
            carDtoConverter = new CarDtoConverter();
        }

        if(categoryDtoConverter == null) {
            categoryDtoConverter = new CategoryDtoConverter();
        }
        ExpenseDto expenseDto = new ExpenseDto();

        expenseDto.setId(expense.getId());
        expenseDto.setName(expense.getName());
        expenseDto.setCost(expense.getCost());
        expenseDto.setDate(expense.getDate());
        expenseDto.setCarDto(carDtoConverter.apply(expense.getCar()));
        expenseDto.setCategoryDto(categoryDtoConverter.apply(expense.getCategory()));

        return expenseDto;


    }
}
