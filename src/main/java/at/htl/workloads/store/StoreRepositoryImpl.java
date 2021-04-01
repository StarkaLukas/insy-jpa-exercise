package at.htl.workloads.store;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class StoreRepositoryImpl implements StoreRepository{

    private final EntityManager entityManager;

    public StoreRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Store getStoreById(Long id) {
        return entityManager.find(Store.class, id);
    }

    @Override
    public void addStore(Store store) {
        entityManager.persist(store);
    }

    @Override
    public List<Store> getAllStores() {
        var query = entityManager.createQuery("select s from Store s", Store.class);
        return query.getResultList();
    }
}
