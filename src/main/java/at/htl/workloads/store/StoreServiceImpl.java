package at.htl.workloads.store;

import at.htl.model.sale.SaleDTO;
import at.htl.model.staff.StaffDTO;
import at.htl.model.store.StoreDTO;
import at.htl.workloads.customer.Customer;
import at.htl.workloads.movie.Movie;
import at.htl.workloads.sale.Sale;
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
        store.setCity(newStore.getCity());
        store.setName(newStore.getName());

        List<Staff> staffList = new ArrayList<>();

        for (StaffDTO staff : newStore.getStaffList()) {
            Staff newStaff = new Staff();
            newStaff.setStore(store);
            newStaff.setSalary(staff.getSalary());
            newStaff.setFirstName(staff.getFirstName());
            newStaff.setLastName(staff.getLastName());
            newStaff.setHireDate(staff.getHireDate());

            for (SaleDTO sale : staff.getSales()) {
                Sale newSale = new Sale();
                newSale.setStaff(newStaff);
                newSale.setPayment_date(sale.getPayment_date());
                newSale.setPrice(sale.getPrice());

                Customer customer = new Customer();
                customer.setDateOfBirth(sale.getCustomer().getDateOfBirth());
                customer.setZip(sale.getCustomer().getZip());
                customer.setFirstName(sale.getCustomer().getFirstName());
                customer.setLastName(sale.getCustomer().getLastName());
                customer.setStreet(sale.getCustomer().getStreet());
                customer.setPlace(sale.getCustomer().getPlace());
                customer.getSales().add(newSale);

                Movie movie = new Movie();
                movie.setLanguage(sale.getMovie().getLanguage());
                movie.setDuration(sale.getMovie().getDuration());
                movie.setRating(sale.getMovie().getRating());
                movie.setYear(sale.getMovie().getYear());
                movie.setTitle(sale.getMovie().getTitle());
                movie.getSales().add(newSale);

                newSale.setCustomer(customer);
                newSale.setMovie(movie);
                newStaff.getSales().add(newSale);
            }

            store.getStaffList().add(newStaff);
        }

        storeRepository.addStore(store);

        return true;
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.getAllStores();
    }
}
