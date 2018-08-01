package com.springmvcresource.dao.impl;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;

import com.springmvcresource.dao.CustomerDAO;
import com.springmvcresource.model.Customer;

@SuppressWarnings("unused")
public class JdbcCustomerDAO implements CustomerDAO {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {

		String sql = "INSERT INTO CUSTOMER "
				+ "(CUST_ID, NAME, AGE, POSITION, TELEPHONE, COMPANY, SALARY) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;

		try {
			// xu ly voi co so du lieu dao
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.setString(4, customer.getPosition());
			ps.setString(5, customer.getTelphone());
			ps.setString(6, customer.getCompany());
			ps.setInt(7, customer.getSalary());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@SuppressWarnings("null")
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID=?";	// find staff by ID
		Customer customer = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"),
						rs.getString("POSITION"), rs.getString("TELEPHONE"), rs.getString("COMPANY"),
						rs.getInt("SALARY"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return customer;
	}

	public List<Customer> listCustomer() {
		String sql = "SELECT * FROM CUSTOMER";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
//			System.out.println(rs);
//			Customer[] listCustomer = new Customer[5];
			 List<Customer> list = new ArrayList<Customer>();
			while (true) {
				if (rs.next()) {
					customer = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"),
							rs.getString("POSITION"), rs.getString("TELEPHONE"), rs.getString("COMPANY"),
							rs.getInt("SALARY"));
					System.out.println(customer);
					list.add(customer);
				} else {
					break;
				}
			}

			rs.close();
			ps.close();
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void deleteCustomer(int custId) {
		String sql = "DELETE FROM CUSTOMER WHERE CUST_ID=?";	// delete staff by ID
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// Parameters start with 1
			ps.setInt(1, custId);	
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updateCustomer(Customer customer) {
		String sql = 
				"UPDATE CUSTOMER "
				+ "SET NAME=?, Age=?, POSITION=?, TELEPHONE=?, COMPANY=?, SALARY=? "
				+ "WHERE CUST_ID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getName());
			ps.setInt(2, customer.getAge());
			ps.setString(3, customer.getPosition());
			ps.setString(4, customer.getTelphone());
			ps.setString(5, customer.getCompany());
			ps.setInt(6, customer.getSalary());
			ps.setInt(7, customer.getCustId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> findByCompany(String company){
		String sql = "SELECT * FROM CUSTOMER WHERE COMPANY=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Customer customer = null;
			ps.setString(1, company);
			ResultSet rs = ps.executeQuery();
//			System.out.println(rs);
//			Customer[] listCustomer = new Customer[5];
			 List<Customer> list = new ArrayList<Customer>();
			while (true) {
				if (rs.next()) {
					customer = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"),
							rs.getString("POSITION"), rs.getString("TELEPHONE"), rs.getString("COMPANY"),
							rs.getInt("SALARY"));
					System.out.println(customer);
					list.add(customer);
				} else {
					break;
				}
			}

			rs.close();
			ps.close();
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	
}
