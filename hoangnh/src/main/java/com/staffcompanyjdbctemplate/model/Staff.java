package com.staffcompanyjdbctemplate.model;

public class Staff {
	int staffid;
	String name;
	String gender;
	int age;
	String company;
	String position;
	String address;
	String email;

	public Staff() {

	}

	public Staff(int staffid, String name, String gender, int age, String company, String position, String address,
			String email) {
		this.staffid = staffid;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.company = company;
		this.position = position;
		this.address = address;
		this.email = email;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ID=" + staffid + ",Name=" + name + ",Gender=" + gender + ",Age=" + age + ",Company=" + company
				+ ",Position=" + position + ",Address=" + address + ",Email=" + email;
	}

}
