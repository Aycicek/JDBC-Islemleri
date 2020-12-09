package com.jdbc.basic.jdbc;

import java.util.Date;

public class Employee {
	
	private Long emp_no;
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthDate;
	private Date hireDate;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Long getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(Long emp_no) {
		this.emp_no = emp_no;
	}
	
	@Override
	public String toString() {
		return "Employee [emp_no=" + emp_no + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", birthDate=" + birthDate + ", hireDate=" + hireDate + "]";
	}
	
	
	
	
	
	

}
