package at.htl.workloads.staff;

import java.util.List;

public class StaffServiceImpl implements StaffService{

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff findStaffById(Long id) {
        return staffRepository.getStaffById(id);
    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffRepository.getAllStaffs();
    }
}
