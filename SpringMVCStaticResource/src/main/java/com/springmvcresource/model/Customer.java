package com.springmvcresource.model;

import java.sql.Timestamp;

@SuppressWarnings("unused")
public class Customer {
	int custId;
	String name;
	int age;
	String position;
	String telephone;
	String company;
	int salary;

	public Customer(int custId, String name, int age, String position, String telephone, String company, int string) {
		this.custId = custId;
		this.name = name;
		this.age = age;
		this.position = position;
		this.telephone = telephone;
		this.company = company;
		this.salary = string;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// posotion
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	// telphone
	public String getTelphone() {
		return telephone;
	}

	public void setTelphone(String telephone) {
		this.telephone = telephone;
	}

	// address
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// salary
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Customer [age=" + age + ", salary =" +salary + ", name=" + name + "]";
	}

}
