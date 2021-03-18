package at.htl.model.staff;

import at.htl.model.person.PersonDTO;

import java.time.LocalDate;

public class StaffDTO extends PersonDTO {
    private LocalDate hireDate;
    private Double salary;

    public StaffDTO(Long id, String firstName, String lastName, LocalDate hireDate, Double salary) {
        super(id, firstName, lastName);
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public StaffDTO() {
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
}
