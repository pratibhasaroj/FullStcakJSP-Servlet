<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Employee Management</h1>
		<h2>
			<a href="new.jsp">Add New Employee</a> &nbsp;&nbsp;&nbsp;
			 <a	href="list.jsp">List All Employee</a>

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Employees</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>EmailId</th>
				<th>Role</th>
				<th>Phone</th>
				<th>Status</th>
			</tr>
			<c:forEach var="emp" items="${requestScope.listEmp}">
				<tr>
					<td><c:out value="${emp.empID}" /></td>
					<td><c:out value="${emp.empName}" /></td>
					<td><c:out value="${emp.password}" /></td>
					<td><c:out value="${emp.emailId}" /></td>
					<td><c:out value="${emp.role}" /></td>
					<td><c:out value="${emp.phone}" /></td>
					<td><c:out value="${emp.Status}" /></td>
					<td><a href="/update?id=<c:out value='${emp.empID}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="/delete?id=<c:out value='${emp.empID}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>