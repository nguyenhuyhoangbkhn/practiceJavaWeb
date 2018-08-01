package com.springmvcresource.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import com.springmvcresource.model.Customer;


@SuppressWarnings({ "unused" })
public interface CustomerDAO 
{
	//interface
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public  List<Customer> listCustomer();
	public  List<Customer> findByCompany(String company);
	public void deleteCustomer(int staffid); // Delete a Staff 
	public void updateCustomer(Customer customer);
}


