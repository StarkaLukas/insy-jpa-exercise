package at.htl.workloads.staff;

import javax.persistence.EntityManager;
import java.util.List;

public class StaffRepositoryImpl implements StaffRepository{

    private final EntityManager em;

    public StaffRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Staff getStaffById(Long id) {
        return em.find(Staff.class, id);
    }

    @Override
    public List<Staff> getAllStaffs() {
        var query = em.createQuery("select s from Staff s", Staff.class);
        return query.getResultList();
    }
}
