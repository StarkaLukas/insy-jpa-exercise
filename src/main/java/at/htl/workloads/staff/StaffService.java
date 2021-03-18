package at.htl.workloads.staff;

import java.util.List;

public interface StaffService {

    Staff findStaffById(Long id);

    List<Staff> getAllStaffs();
}
