package at.htl.workloads.category;

import at.htl.model.category.CategoryDTO;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long id);

    boolean addCategory(CategoryDTO newCategory);

    List<Category> getAllCategories();
}
