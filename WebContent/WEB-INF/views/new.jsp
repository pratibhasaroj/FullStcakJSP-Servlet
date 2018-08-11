<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
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
            <a href="/new">Add New Employee</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Employee</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${emp != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${emp == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${emp != null}">
                        Edit Employee
                    </c:if>
                    <c:if test="${emp == null}">
                        Add New Employee
                    </c:if>
                </h2>
            </caption>
                <c:if test="${emp != null}">
                    <input type="hidden" name="id" value="<c:out value='${emp.id}' />" />
                </c:if>           
            <tr>
                <th>EmpID: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${emp.empId}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Employee Name: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${emp.empName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Password: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${emp.password}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Employee : </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${emp.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
       </form>
        
    </div>   
</body>
</html>