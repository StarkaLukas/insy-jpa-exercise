package at.htl.model.sale;

import at.htl.model.customer.CustomerDTO;
import at.htl.model.movie.MovieDTO;
import at.htl.model.staff.StaffDTO;

import java.time.LocalDate;

public class SaleDTO {

    private Long id;
    private MovieDTO movie;
    private CustomerDTO customer;
    private StaffDTO staff;
    private LocalDate payment_date;
    private Double price;

    public SaleDTO() {
    }

    public SaleDTO(Long id, MovieDTO movie, CustomerDTO customer, StaffDTO staff, LocalDate payment_date, Double price) {
        this.id = id;
        this.movie = movie;
        this.customer = customer;
        this.staff = staff;
        this.payment_date = payment_date;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public StaffDTO getStaff() {
        return staff;
    }

    public void setStaff(StaffDTO staff) {
        this.staff = staff;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
