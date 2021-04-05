package at.htl.workloads.customer;

import java.util.List;

public interface CustomerRepository {

    Customer getCustomerById(Long id);

    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    double getTotalExpensesOfCustomer(Long id);
}
