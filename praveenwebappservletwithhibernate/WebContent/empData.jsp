<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 2px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

a {
	color: #005b7f;
	text-decoration: underline;
	font-weight: bolder;
}
</style>

<script>
	function confirmFunc() {
		var v = confirm("Are you sure, you want to delete ?");
		if (v) {
			return true;
		} else {
			return false;
		}
	}
</script>

</head>
<body>
	<p align="center">
		<font color='green'> ${deleteSuccMsg} ${deleteFailMsg} </font>
	</p>
	<h3 align="center">View Employee Records</h3>
	<h3 align="center">
		<a href="index.jsp">+ Add New Employee</a>
	</h3>
	<table border="1" align="center">

		<thead>
			<tr>
				<th>S.No</th>
				<th>Emp Id</th>
				<th>Emp Name</th>
				<th>Emp Email</th>
				<th>Emp Salary</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${empList}" var="emp" varStatus="counter">
				<tr>
					<td><c:out value="${counter.index+1}" /></td>
					<td><c:out value="${emp.eid}" /></td>
					<td><c:out value="${emp.ename}" /></td>
					<td><c:out value="${emp.email}" /></td>
					<td><c:out value="${emp.salary}" /></td>
					<td><a href="EditEmpServlet?empId=${emp.eid}">Edit</a>/ 
					<a href="DeleteEmpServlet?empId=${emp.eid}"
						onclick="return confirmFunc()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p align="center">

		<%
			Integer totalPages = (Integer) request.getAttribute("totalPages");
			for (int i = 1; i <= totalPages; i++) {
				out.print("<a href=\"viewEmpData?pageNumber=" + i + "   \">"
						+ i + "</a>");
				out.print("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp");
			}
		%>
	</p>
</body>
</html>