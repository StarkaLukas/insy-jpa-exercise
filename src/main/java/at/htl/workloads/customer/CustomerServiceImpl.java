package at.htl.workloads.customer;

import at.htl.model.customer.CustomerDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public boolean addCustomer(CustomerDTO newCustomer) {
        Customer existingCustomer = customerRepository.getCustomerById(newCustomer.getId());

        if (existingCustomer != null) {
            return false;
        }

        Customer customer = new Customer();

        customer.setId(newCustomer.getId());
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setPlace(newCustomer.getPlace());
        customer.setStreet(newCustomer.getStreet());
        customer.setZip(newCustomer.getZip());
        customer.setDateOfBirth(newCustomer.getDateOfBirth());
        customerRepository.addCustomer(customer);

        return true;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
