package at.htl.workloads.staff;

import at.htl.workloads.person.Person;
import at.htl.workloads.sale.Sale;
import at.htl.workloads.store.Store;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@DiscriminatorValue(value = "Staff")
public class Staff extends Person {

    private LocalDate hireDate;
    private Double salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.PERSIST)
    private List<Sale> sales = new ArrayList<>();

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
