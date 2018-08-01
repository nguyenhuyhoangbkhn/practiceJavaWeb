package com.staffcompanyjdbctemplate.dao;

import java.util.List;

import com.staffcompanyjdbctemplate.model.Staff;

public interface StaffDao {
	public List<Staff> getAllStaff();
	public List<Staff> getStaffByNameCompany(String company);
	public Staff findByStaffId(int staffid);
	public int addStaff(Staff staff);
	public int deleteStaff(int staffid);
	public int updateStaff(Staff staff);
}
