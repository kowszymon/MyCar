package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.converters.CategoryConverter;
import kowszymon.ownProjects.myCar.converters.CategoryDtoConverter;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.exceptions.CannotDeleteItemException;
import kowszymon.ownProjects.myCar.exceptions.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {


    List<CategoryDto> findCategories();

    CategoryDto findCategoryById(Long categoryId) throws CategoryNotFoundException;

    void save(CategoryDto categoryDto);

    void delete(Long categoryId) throws CannotDeleteItemException;

}
