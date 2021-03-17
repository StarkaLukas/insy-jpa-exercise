package at.htl.workloads.staff;

import at.htl.workloads.person.Person;
import at.htl.workloads.store.Store;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Staff extends Person {

    private LocalDate hireDate;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
