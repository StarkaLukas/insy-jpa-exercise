package at.htl.workloads.category;

import at.htl.model.category.CategoryDTO;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    @Override
    public boolean addCategory(CategoryDTO newCategory) {
        Category existingCategory = categoryRepository.getCategoryById(newCategory.getId());

        if (existingCategory != null) {
            return false;
        }

        Category category = new Category();
        category.setId(newCategory.getId());
        category.setName(newCategory.getName());

        return true;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }
}
