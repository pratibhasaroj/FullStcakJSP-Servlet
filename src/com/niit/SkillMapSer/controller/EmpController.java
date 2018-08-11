package com.niit.SkillMapSer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.SkillMapSer.dao.EmployeeDao;
import com.niit.SkillMapSer.model.Employee;

@WebServlet(name="EmpController", urlPatterns= {"/"})
public class EmpController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmployeeDao empdao;

	public EmpController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {

			case "/":
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
				dispatcher.forward(request, response);
				break;
			case "/index":

				listEmp(request, response);
				break;
			case "/insert":
				insertEmp(request, response);
				break;
			case "/delete":
				// deleteEmp(request, response);
				break;
			case "/edit":
				// showEditEmp(request, response);
				break;
			case "/update":
				// updateEmp(request, response);
				break;
			default:

				listEmp(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listEmp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Employee> listEmp = empdao.getAllEmployees();
		request.setAttribute("listEmp", listEmp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

	private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int empID = Integer.parseInt(request.getParameter("empID"));
		String empName = request.getParameter("empName");
		String password = request.getParameter("password");
		String emailId = request.getParameter("emailId");
		String role = request.getParameter("role");
		String phone = request.getParameter("phone");
		boolean status = false;

		Employee emp = new Employee(empID, empName, password, emailId, role, phone, status);

		empdao.insertEmp(emp);
		response.sendRedirect("list");
	}

	/*
	 * private void showNewForm(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { RequestDispatcher dispatcher
	 * = request.getRequestDispatcher("new.jsp"); dispatcher.forward(request,
	 * response); }
	 */
}
