package kowszymon.ownProjects.myCar.dao;

import kowszymon.ownProjects.myCar.entities.Category;


import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void delete(Long id);
}
