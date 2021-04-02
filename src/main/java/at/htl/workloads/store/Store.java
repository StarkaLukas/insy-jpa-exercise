package at.htl.workloads.store;

import at.htl.workloads.staff.Staff;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1000)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String name;
    private String city;

    @OneToMany(mappedBy = "store", cascade = CascadeType.PERSIST)
    private List<Staff> staffList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
