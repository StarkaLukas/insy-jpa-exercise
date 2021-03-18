package at.htl.workloads.customer;

import at.htl.workloads.person.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends Person {

    private LocalDate dateOfBirth;
    private String place;
    private String street;
    private String zip;

    @OneToMany(mappedBy = "id")
    private List<Customer> sales = new ArrayList<Customer>();

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<Customer> getSales() {
        return sales;
    }

    public void setSales(List<Customer> sales) {
        this.sales = sales;
    }
}
