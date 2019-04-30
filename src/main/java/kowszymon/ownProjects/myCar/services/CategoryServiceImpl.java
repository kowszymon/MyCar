package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.converters.CategoryConverter;
import kowszymon.ownProjects.myCar.converters.CategoryDtoConverter;
import kowszymon.ownProjects.myCar.dao.CategoryDao;
import kowszymon.ownProjects.myCar.dao.CategoryDaoImpl;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.entities.Category;
import kowszymon.ownProjects.myCar.exceptions.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();


    CategoryConverter categoryConverter = new CategoryConverter();

    CategoryDtoConverter categoryDtoConverter = new CategoryDtoConverter();

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
            throw new CategoryNotFoundException("Category with id = " + categoryId + " was not found");
        }
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = categoryConverter.apply(categoryDto);

        categoryDao.save(category);
    }

    @Override
    public void delete(Long categoryId) {
        categoryDao.delete(categoryId);
    }
}
