package at.htl.workloads.staff;

import java.util.List;

public interface StaffRepository {

    Staff getStaffById(Long id);

    List<Staff> getAllStaffs();
}
