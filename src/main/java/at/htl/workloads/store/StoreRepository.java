package at.htl.workloads.store;

import java.util.List;

public interface StoreRepository {
    Store getStoreById(Long id);

    void addStore(Store store);

    List<Store> getAllStores();
}
