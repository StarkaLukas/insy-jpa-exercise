package at.htl.workloads.customer;

import at.htl.IntTestBase;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class CustomerRepositoryTest {

    @Inject
    CustomerRepositoryImpl customerRepository;

    @Test
    @Transactional
    public void addCustomer_getCustomer_simple_success() {
        Customer customer = new Customer();
        customer.setFirstName("Custi");
        customer.setLastName("Custo");
        customer.setDateOfBirth(LocalDate.of(1990, 4, 9));
        customer.setZip("1010");
        customer.setPlace("Coolplace");
        customer.setStreet("Nicestreet 1");

        assertThatCode(() -> customerRepository.addCustomer(customer)).doesNotThrowAnyException();
        Customer loadedCustomer = customerRepository.getCustomerById(customer.getId());

        assertThat(loadedCustomer).isNotNull().isEqualTo(customer);
    }

    @Test
    @Transactional
    public void addCustomers_getAllCustomers_success() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Custi");
        customer1.setLastName("Custo");
        customer1.setDateOfBirth(LocalDate.of(1990, 4, 9));
        customer1.setZip("1010");
        customer1.setPlace("Coolplace");
        customer1.setStreet("Nicestreet 1");

        Customer customer2 = new Customer();
        customer2.setFirstName("Cleveland");
        customer2.setLastName("Client");
        customer2.setDateOfBirth(LocalDate.of(1987, 10, 27));
        customer2.setZip("1020");
        customer2.setPlace("Whackplace");
        customer2.setStreet("Garbagestreet 1");

        int savedCustomers = customerRepository.getAllCustomers().size();

        assertThatCode(() -> customerRepository.addCustomer(customer1)).doesNotThrowAnyException();
        assertThatCode(() -> customerRepository.addCustomer(customer2)).doesNotThrowAnyException();

        List<Customer> loadedCustomer = customerRepository.getAllCustomers();

        assertThat(loadedCustomer.size()).isEqualTo(savedCustomers + 2);
        assertThat(loadedCustomer.get(savedCustomers)).isEqualTo(customer1);
        assertThat(loadedCustomer.get(savedCustomers + 1)).isEqualTo(customer2);
    }

}
