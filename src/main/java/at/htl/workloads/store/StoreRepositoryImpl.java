package at.htl.workloads.store;

import at.htl.workloads.staff.Staff;

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

    @Override
    public List<StoreLocationCount> getLocationAndCountStaff() {
        var query = entityManager.createQuery(
                "select NEW at.htl.workloads.store.StoreLocationCount(s.store.city, count(s.store.city)) from Staff s group by s.store.city",
                StoreLocationCount.class
        );
        return query.getResultList();
    }
}
