package at.htl.workloads.category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository{

    private final EntityManager entityManager;

    public CategoryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Category getCategoryById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void addCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    public List<Category> getCategoryList() {
        var query = entityManager.createQuery("select c from Category c", Category.class);
        return query.getResultList();
    }
}
