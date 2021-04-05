package at.htl.workloads.customer;

import at.htl.workloads.person.Person;
import at.htl.workloads.sale.Sale;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@DiscriminatorValue(value = "Customer")
public class Customer extends Person {

    @JsonbDateFormat("dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private String place;
    private String street;
    private String zip;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    @JsonbTransient
    private List<Sale> sales = new ArrayList<>();

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

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
