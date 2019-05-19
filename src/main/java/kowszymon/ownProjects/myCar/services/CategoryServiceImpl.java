package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.converters.CategoryConverter;
import kowszymon.ownProjects.myCar.converters.CategoryDtoConverter;
import kowszymon.ownProjects.myCar.dao.CategoryDao;
import kowszymon.ownProjects.myCar.dao.CategoryDaoImpl;
import kowszymon.ownProjects.myCar.dao.ExpenseDao;
import kowszymon.ownProjects.myCar.dao.ExpenseDaoImpl;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.entities.Category;
import kowszymon.ownProjects.myCar.exceptions.CannotDeleteItemException;
import kowszymon.ownProjects.myCar.exceptions.CategoryNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();


    CategoryConverter categoryConverter = new CategoryConverter();

    CategoryDtoConverter categoryDtoConverter = new CategoryDtoConverter();

    ExpenseService expenseService = new ExpenseServiceImpl();

    @Override
    public List<CategoryDto> findCategories() {
        List<Category> categories = categoryDao.findAll();

        return categories.stream()
                .map(categoryDtoConverter)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findCategoryById(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> categoryOptional = categoryDao.findById(categoryId);

        if(categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            CategoryDto categoryDto = categoryDtoConverter.apply(category);
            return categoryDto;
        } else {
            throw new CategoryNotFoundException("Kategoria o id= " + categoryId + " nie została znaleziona");
        }
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = categoryConverter.apply(categoryDto);

        categoryDao.save(category);
    }

    @Override
    public void delete(Long categoryId) throws CannotDeleteItemException {
        List<ExpenseDto> expenses = expenseService.findExpenses();

        List<ExpenseDto> expensesWithThisCategory = new ArrayList<>();

        if (!expenses.isEmpty()) {
            for (ExpenseDto e : expenses) {
                if (e.getCategoryDto().getId().equals(categoryId)) {
                    expensesWithThisCategory.add(e);
                }
            }

            if(expensesWithThisCategory.size() == 1) {
                throw new CannotDeleteItemException("Wydatek \"" + expensesWithThisCategory.get(0).getName() +
                        "\" należy do tej kategorii. " +
                        "Edytuj go przed jej usunięciem.", expensesWithThisCategory.get(0).getId());
            } else if(expensesWithThisCategory.size() > 1){
                throw new CannotDeleteItemException("Poniżej znajduje się lista wydatków, które należą do tej kategorii." +
                        " Edytuj je przed jej usunięciem.", expensesWithThisCategory);
            }
        }

        categoryDao.delete(categoryId);
    }

}
