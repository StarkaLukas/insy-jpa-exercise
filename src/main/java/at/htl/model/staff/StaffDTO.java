package at.htl.model.staff;

import at.htl.model.person.PersonDTO;
import at.htl.model.sale.SaleDTO;
import at.htl.model.store.StoreDTO;

import java.time.LocalDate;
import java.util.List;

public class StaffDTO extends PersonDTO {
    private LocalDate hireDate;
    private Double salary;
    private StoreDTO store;
    private List<SaleDTO> sales;

    public StaffDTO() {
    }

    public StaffDTO(Long id, String firstName, String lastName, LocalDate hireDate, Double salary, StoreDTO store, List<SaleDTO> sales) {
        super(id, firstName, lastName);
        this.hireDate = hireDate;
        this.salary = salary;
        this.store = store;
        this.sales = sales;
    }

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

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public List<SaleDTO> getSales() {
        return sales;
    }

    public void setSales(List<SaleDTO> sales) {
        this.sales = sales;
    }
}
