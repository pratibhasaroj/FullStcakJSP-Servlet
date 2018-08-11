package com.niit.SkillMapSer.dao;


import java.util.List;

import com.niit.SkillMapSer.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int id);
	public boolean deleteEmp(Employee emp);
	public boolean insertEmp(Employee emp);
	public boolean updateEmp(Employee emp);
	

}
