package com.niit.SkillMapSer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.SkillMapSer.dao.EmployeeDao;
import com.niit.SkillMapSer.daoImpl.EmployeeDaoImpl;
import com.niit.SkillMapSer.model.Employee;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Employee emp=new Employee();
		
		int empID= Integer.parseInt(request.getParameter("empID"));
        String empName = request.getParameter("empName");
        String password = request.getParameter("password");
        String emailId = request.getParameter("emailId");
        String role = request.getParameter("role");
        String phone= request.getParameter("phone");
        boolean status= false;
 
        Employee emp = new Employee(empID, empName, password,emailId,role,phone,status);
         EmployeeDao empdao=new EmployeeDaoImpl();
   	 
       boolean count= empdao.insertEmp(emp);
       if(count==true) {
        System.out.println("success");
       response.sendRedirect("/WEB-INF/views/index.jsp");
       }
       else
       {
        
    	   System.out.println("unsuccess");
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
