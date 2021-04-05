package at.htl.workloads.category;

import java.util.List;

public interface CategoryRepository {

    Category getCategoryById(Long id);

    List<Category> getAllCategories();
}
