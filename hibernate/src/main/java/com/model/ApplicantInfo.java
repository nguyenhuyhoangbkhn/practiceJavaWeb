package com.model;

public class ApplicantInfo {

	private String id;
	private String name;
	private String email;

	private String position;
	private String gender;
	private String company;

	public ApplicantInfo() {

	}

	public ApplicantInfo(String id, String name, String email, String gender, String position, String company) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.position = position;
		this.gender = gender;
		this.company = company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String toString(){
		return "demo="+this.getCompany();
	}
}
