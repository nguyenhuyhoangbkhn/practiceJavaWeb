package com.staffcompanyjdbctemplate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.staffcompanyjdbctemplate.model.Staff;

@SuppressWarnings("unused")
public class StaffDaoImpl implements StaffDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addStaff(Staff staff) {
		String sql = "insert into STAFFS (staffid,name,gender,age,company,position,address,email) values (?, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, staff.getStaffid(), staff.getName(), staff.getGender(), staff.getAge(),
				staff.getCompany(), staff.getPosition(), staff.getAddress(), staff.getEmail());
	}

	public int deleteStaff(int staffid) {
		String sql = "delete from STAFFS where staffid=" + staffid + "";
		return jdbcTemplate.update(sql);
	}

	public int updateStaff(Staff staff) {
		String sql = "UPDATE STAFFS SET name=?, gender=?, age=?, company=?, position=?, address=?, "
				+ "email=? WHERE staffid=?";
		return jdbcTemplate.update(sql, staff.getName(), staff.getGender(), staff.getAge(), staff.getCompany(),
				staff.getPosition(), staff.getAddress(), staff.getEmail(), staff.getStaffid());
	}

	public List<Staff> getAllStaff() {
		return jdbcTemplate.query("select * from STAFFS", new RowMapper<Staff>() {
			public Staff mapRow(ResultSet rs, int row) throws SQLException {
				Staff staff = new Staff();
				staff.setStaffid(rs.getInt(1));
				staff.setName(rs.getString(2));
				staff.setGender(rs.getString(3));
				staff.setAge(rs.getInt(4));
				staff.setCompany(rs.getString(5));
				staff.setPosition(rs.getString(6));
				staff.setAddress(rs.getString(7));
				staff.setEmail(rs.getString(8));
				return staff;
			}
		});
	}

	public Staff findByStaffId(int staffid) {
		String sql = "select * from STAFFS where staffid=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { staffid },
				new BeanPropertyRowMapper<Staff>(Staff.class));
	}

	public List<Staff> getStaffByNameCompany(String company) {
		String sql="select * from STAFFS where company = '"+ company+ "'";
		System.out.println("company"+ sql);
		return jdbcTemplate.query(sql, new RowMapper<Staff>() {
			public Staff mapRow(ResultSet rs, int row) throws SQLException {
				Staff staff = new Staff();
				staff.setStaffid(rs.getInt(1));
				staff.setName(rs.getString(2));
				staff.setGender(rs.getString(3));
				staff.setAge(rs.getInt(4));
				staff.setCompany(rs.getString(5));
				staff.setPosition(rs.getString(6));
				staff.setAddress(rs.getString(7));
				staff.setEmail(rs.getString(8));
				return staff;
			}
		});
	}
}
