package com.niit.SkillMapSer.model;

public class Employee {
	
	private int empID;
	private String empName;
	private String password;
	private String emailId;
	private String role;
	private String phone;
	private boolean status=false;
	
		public Employee(int empID, String empName, String password, String emailId, String role, String phone, boolean status2) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.password = password;
		this.emailId = emailId;
		this.role = role;
		this.phone = phone;
		this.status = false;
	}
	public Employee()
	{
		
	}
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	

}
