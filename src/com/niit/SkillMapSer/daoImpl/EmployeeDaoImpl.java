package com.niit.SkillMapSer.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.niit.SkillMapSer.config.H2Config;
import com.niit.SkillMapSer.dao.EmployeeDao;
import com.niit.SkillMapSer.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	
	Connection con;
	
	public EmployeeDaoImpl() {
		con= H2Config.getConnection();
	}
	
	// PreparedStatement st;
	// Scanner sc=new Scanner(System.in);

	@Override
	public List<Employee> getAllEmployees() {

		try {
			
			System.out.println(con);
			List<Employee> listEmp = new ArrayList<>();

			String sql = "SELECT * FROM emp";

			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int empID = resultSet.getInt("empID");
				String empName = resultSet.getString("empName");
				String password = resultSet.getString("password");
				String emailId = resultSet.getString("emailId");
				String role = resultSet.getString("role");
				String phone = resultSet.getString("phone");
				boolean status = resultSet.getBoolean("status");

				Employee emp = new Employee(empID, empName, password, emailId, role, phone, status);
				
				listEmp.add(emp);
				
			}

			resultSet.close();
			statement.close();

			return listEmp;
		} catch (Exception e) {
			System.out.println(e);

		}
		return null;
	}

	@Override
	public Employee getEmployee(int id) {

		try {
			Connection con = H2Config.getConnection();
			Employee emp = null;
			String sql = "SELECT * FROM emp WHERE empID = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String empName = resultSet.getString("empName");
				String password = resultSet.getString("password");
				String emailId = resultSet.getString("emailId");
				String role = resultSet.getString("role");
				String phone = resultSet.getString("phone");
				Boolean status = resultSet.getBoolean("status");

				emp = new Employee(id, empName, password, emailId, role, phone, status);
			}

			resultSet.close();
			statement.close();

			return emp;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public boolean deleteEmp(Employee emp) {

		try {

			Connection con = H2Config.getConnection();
			String sql = "DELETE FROM emp where empID = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, emp.getEmpID());
			boolean rowDeleted = statement.executeUpdate() > 0;
			statement.close();
			return rowDeleted;
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;

	}

	@Override
	public boolean insertEmp(Employee emp) {

		try {
			Connection con = H2Config.getConnection();

			String sql = "INSERT INTO Emp (empID, empName, password,emailId,role,phone,status) VALUES (?, ?, ?,?,?,?,?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, emp.getEmpID());
			statement.setString(2, emp.getEmpName());
			statement.setString(3, emp.getPassword());
			statement.setString(4, emp.getEmailId());
			statement.setString(5, emp.getRole());
			statement.setString(6, emp.getPhone());
			statement.setBoolean(7, false);

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			return rowInserted;

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	@Override
	public boolean updateEmp(Employee emp) {
		try {
			Connection con = H2Config.getConnection();
			String sql = "UPDATE emp SET  empName = ?,password  = ?,emailId=?,role=?,phone=?";
			sql += " WHERE empID = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, emp.getEmpID());
			statement.setString(2, emp.getEmpName());
			statement.setString(3, emp.getPassword());
			statement.setString(4, emp.getEmailId());
			statement.setString(5, emp.getRole());
			statement.setString(6, emp.getPhone());

			boolean rowUpdated = statement.executeUpdate() > 0;
			statement.close();
			return rowUpdated;
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;

	}

}
