package at.htl.workloads.store;

import at.htl.workloads.staff.Staff;

import java.util.List;

public interface StoreRepository {
    Store getStoreById(Long id);

    void addStore(Store store);

    List<Store> getAllStores();

    List<StoreLocationCount> getLocationAndCountStaff();
}
