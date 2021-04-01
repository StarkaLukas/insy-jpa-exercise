package at.htl.workloads.store;

import at.htl.model.staff.StaffDTO;
import at.htl.model.store.StoreDTO;
import at.htl.workloads.staff.Staff;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.getStoreById(id);
    }

    @Override
    public boolean addStore(StoreDTO newStore) {
        Store existingStore = storeRepository.getStoreById(newStore.getId());

        if (existingStore != null) {
            return false;
        }

        Store store = new Store();
        store.setId(newStore.getId());
        store.setCity(newStore.getCity());
        store.setName(newStore.getName());

//        List<Staff> staffList = new ArrayList<>();
//
//        for (StaffDTO staff : newStore.getStaffList()) {
//            Staff newStaff = new Staff();
//            newStaff.setId(staff.getId());
//            newStaff.setStore(store);
//            newStaff.setSalary(staff.getSalary());
//            newStaff.setSales(staff.getS);
//        }

        storeRepository.addStore(store);

        return true;
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.getAllStores();
    }
}
