package at.htl.workloads.category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long id);

    List<Category> getAllCategories();
}
