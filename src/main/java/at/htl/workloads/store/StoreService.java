package at.htl.workloads.store;

import at.htl.model.store.StoreDTO;

import java.util.List;

public interface StoreService {
    Store getStoreById(Long id);

    boolean addStore(StoreDTO newStore);

    List<Store> getAllStores();

    List<StoreLocationCount> getLocationAndCountStaff();
}
