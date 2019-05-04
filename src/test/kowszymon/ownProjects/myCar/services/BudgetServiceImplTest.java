package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.dto.IncomeDto;
import kowszymon.ownProjects.myCar.entities.Expense;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class BudgetServiceImplTest {


    IncomeService incomeService = new IncomeServiceImpl();

    ExpenseService expenseService = new ExpenseServiceImpl();

    BudgetService budgetService = new BudgetServiceImpl();

    CarService carService = new CarServiceImpl();

    CategoryService categoryService = new CategoryServiceImpl();

    CarDto carDto = new CarDto();


    CategoryDto categoryDto = new CategoryDto();


    IncomeDto incomeDto = new IncomeDto(BigDecimal.valueOf(200.0),
            LocalDate.of(2018, 3, 15));

    IncomeDto incomeDto2 = new IncomeDto(BigDecimal.valueOf(20.0),
            LocalDate.of(2016, 3, 15));

    IncomeDto incomeDto3 = new IncomeDto(BigDecimal.valueOf(800.0),
            LocalDate.of(2017, 3, 15));

    IncomeDto incomeDto4 = new IncomeDto(BigDecimal.valueOf(100.0),
            LocalDate.of(2019, 3, 15));

    ExpenseDto expenseDto = new ExpenseDto("test1", categoryDto,
            LocalDate.of(2019, 3, 15), BigDecimal.valueOf(30.0), carDto);

    ExpenseDto expenseDto2 = new ExpenseDto("test2", categoryDto,
            LocalDate.of(2019, 3, 15), BigDecimal.valueOf(400.0), carDto);

    ExpenseDto expenseDto3 = new ExpenseDto("test3", categoryDto,
            LocalDate.of(2019, 3, 15), BigDecimal.valueOf(50.0), carDto);
    ExpenseDto expenseDto4 = new ExpenseDto("test4", categoryDto,
            LocalDate.of(2019, 3, 15), BigDecimal.valueOf(20.0), carDto);


    @Test
    public void incomesSum() {
        incomeService.save(incomeDto);
        incomeService.save(incomeDto2);
        incomeService.save(incomeDto3);
        incomeService.save(incomeDto4);
        Assert.assertEquals(BigDecimal.valueOf(112000, 2), budgetService.incomesSum());
    }

    @Test
    public void expensesSum() {
        categoryDto.setName("testCategory");
        categoryService.save(categoryDto);

        carDto.setName("testCar");
        carService.save(carDto);

        expenseService.save(expenseDto);
        expenseService.save(expenseDto2);
        expenseService.save(expenseDto3);
        expenseService.save(expenseDto4);
        Assert.assertEquals(BigDecimal.valueOf(50000, 2), budgetService.expensesSum());
    }

    @Test
    public void budgetCount() {
        incomeService.save(incomeDto);
        incomeService.save(incomeDto2);
        incomeService.save(incomeDto3);
        incomeService.save(incomeDto4);
        categoryDto.setName("testCategory");
        categoryService.save(categoryDto);

        carDto.setName("testCar");
        carService.save(carDto);

        expenseService.save(expenseDto);
        expenseService.save(expenseDto2);
        expenseService.save(expenseDto3);
        expenseService.save(expenseDto4);
        Assert.assertEquals(BigDecimal.valueOf(62000, 2), budgetService.budgetCount());


    }


}