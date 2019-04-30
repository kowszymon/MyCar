package kowszymon.ownProjects.myCar.converters;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.entities.Car;
import kowszymon.ownProjects.myCar.entities.Category;
import kowszymon.ownProjects.myCar.entities.Expense;

import java.util.function.Function;

public class ExpenseConverter implements Function<ExpenseDto, Expense> {

    private Function<CarDto, Car> carConverter;
    private Function<CategoryDto, Category> categoryConverter;

    @Override
    public Expense apply(ExpenseDto expenseDto) {

        if(carConverter == null) {
            carConverter = new CarConverter();
        }

        if(categoryConverter == null) {
            categoryConverter = new CategoryConverter();
        }

        Expense expense = new Expense();

        expense.setId(expenseDto.getId());
        expense.setName(expenseDto.getName());
        expense.setDate(expenseDto.getDate());
        expense.setCost(expenseDto.getCost());

        if(expenseDto.getCarDto()  != null){
            expense.setCar(carConverter.apply(expenseDto.getCarDto()));

        }

        if(expenseDto.getCategoryDto() != null) {
            expense.setCategory(categoryConverter.apply(expenseDto.getCategoryDto()));
        }

        return expense;
    }
}
