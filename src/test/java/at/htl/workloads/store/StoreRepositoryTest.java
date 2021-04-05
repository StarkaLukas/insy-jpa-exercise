package at.htl.workloads.store;

import at.htl.IntTestBase;
import at.htl.workloads.sale.Sale;
import at.htl.workloads.staff.Staff;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@QuarkusTest
public class StoreRepositoryTest extends IntTestBase{

    @Inject
    private StoreRepositoryImpl storeRepository;

    @Test
    public void addStore_getStore_simple_success() {
        Store store = new Store();
        store.setName("CoolCinema");
        store.setCity("Coolcity");

        List<Staff> staffList = new ArrayList<>();
        Staff staff = new Staff();
        staff.setFirstName("Staffi");
        staff.setLastName("Staffenstein");
        staff.setSalary(1350.00);
        staff.setHireDate(LocalDate.of(2019, 4, 15));
        staff.setStore(store);

        staffList.add(staff);

        store.setStaffList(staffList);

        assertThatCode(() -> storeRepository.addStore(store)).doesNotThrowAnyException();
        Store loadedStore = storeRepository.getStoreById(store.getId());

        assertThat(loadedStore).isNotNull().isEqualTo(store);
    }

    @Test
    public void addStores_getStores_success() {
        Store store1 = new Store();
        store1.setName("CoolCinema");
        store1.setCity("Coolcity");

        List<Staff> staffList = new ArrayList<>();
        Staff staff = new Staff();
        staff.setFirstName("Staffi");
        staff.setLastName("Staffenstein");
        staff.setSalary(1350.00);
        staff.setHireDate(LocalDate.of(2019, 4, 15));
        staff.setStore(store1);

        staffList.add(staff);

        Store store2 = new Store();
        store2.setName("Filmlovers");
        store2.setCity("Notsocoolcity");

        store1.setStaffList(staffList);

        int savedStores = storeRepository.getAllStores().size();

        assertThatCode(() -> storeRepository.addStore(store1)).doesNotThrowAnyException();
        assertThatCode(() -> storeRepository.addStore(store2)).doesNotThrowAnyException();

        List<Store> loadedStores = storeRepository.getAllStores();

        assertThat(loadedStores.size()).isEqualTo(savedStores + 2);
        assertThat(loadedStores.get(savedStores)).isEqualTo(store1);
        assertThat(loadedStores.get(savedStores + 1)).isEqualTo(store2);
    }

    @Test
    public void getStore_notExists() {
        AtomicReference<Store> loadedStore = new AtomicReference<>();
        assertThatCode(() -> {
            loadedStore.set(storeRepository.getStoreById(1000L));
        }).doesNotThrowAnyException();

        assertThat(loadedStore.get()).isNull();
    }
}
