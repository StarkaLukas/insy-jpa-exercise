package at.htl.workloads.customer;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class CustomerRepositoryImpl implements CustomerRepository{

    private final EntityManager em;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public Customer getCustomerById(Long id) {
        var query = em.createQuery("select c from Customer c where c.id = :id", Customer.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addCustomer(Customer customer) {
        em.persist(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        var query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }
}
