package at.htl.workloads.category;

import java.util.List;

public interface CategoryRepository {

    Category getCategoryById(Long id);

    void addCategory(Category category);

    List<Category> getAllCategories();
}
