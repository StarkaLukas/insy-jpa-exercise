package at.htl.workloads.customer;

import at.htl.model.Customer.CustomerDTO;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long id);

    boolean addCustomer(CustomerDTO newCustomer);

    List<Customer> getAllCustomers();
}
