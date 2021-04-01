package at.htl.model.store;

import at.htl.model.staff.StaffDTO;

import java.util.List;

public class StoreDTO {
    private Long id;
    private String name;
    private String city;
    private List<StaffDTO> staffList;

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name, String city, List<StaffDTO> staffList) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.staffList = staffList;
    }

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

    public List<StaffDTO> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<StaffDTO> staffList) {
        this.staffList = staffList;
    }
}
