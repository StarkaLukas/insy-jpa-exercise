package at.htl.workloads.store;

public class StoreLocationCount {

    private String location;
    private Long count;

    public StoreLocationCount(String location, Long count) {
        this.location = location;
        this.count = count;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
