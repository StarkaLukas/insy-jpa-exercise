package at.htl.workloads.sale;

import at.htl.workloads.customer.Customer;
import at.htl.workloads.movie.Movie;
import at.htl.workloads.staff.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @Cascade(CascadeType.ALL)
    private Movie movie;

    @ManyToOne
    @JsonIgnore
    @Cascade(CascadeType.ALL)
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    @Cascade(CascadeType.ALL)
    private Staff staff;

    @JsonbDateFormat("dd-MM-yyyy")
    private LocalDate payment_date;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
