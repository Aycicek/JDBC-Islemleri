package com.jdbc.basic.jdbc;

public class Departments {
	
	private String dept_no;
	private String dept_name;
	
	public String getDept_no() {
		return dept_no;
	}
	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	
	@Override
	public String toString() {
		return "Departments [dept_no=" + dept_no + ", dept_name=" + dept_name + "]";
	}
	
	

}
