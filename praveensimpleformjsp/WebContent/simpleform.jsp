<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*" errorPage=""%>
<%@page import="java.util.*"%>
<%@include file="database.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Form Page</title>
</head>
<body>
	<form action="#" method="post">
		<table width="350" border="1">
			<tr>
				<td><label>Enter Your Name</label></td>
				<td><input name="first_name" type="text">&nbsp;</td>
			</tr>
			<tr>
				<td>Enter Father Name</td>
				<td><input name="last_name" type="text"></td>
			</tr>
			<tr>
				<td>Enter Surname</td>
				<td><input name="sur_name" type="text"></td>
			</tr>
			<tr>
				<td colspan="2"><center>
						<input name="" type="submit">
					</center></td>
			</tr>
		</table>
	</form>
	<h2>Using GET/POST Method to Read Form Data</h2>
	<%
		Database db = new Database();
		db.init();
		if (request.getMethod().equalsIgnoreCase("POST")) {
			try {
				String Id = request.getParameter("stdId");
				String name = request.getParameter("first_name").trim();
				String fname = request.getParameter("last_name").trim();
				String surname = request.getParameter("sur_name").trim();
				if (name.length() != 0 && fname.length() != 0) {
					db.addStudent(name, fname, surname);
				}
				Vector<Bean> vect = db.getStudent();
	%>
	<table width="350" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Father Name</th>
			<th>Surname</th>
		</tr>
		<%
			for (Bean std : vect) {
		%>
		<tr>
			<td><%=std.Id%></td>
			<td><%=std.Name%></td>
			<td><%=std.Fname%></td>
			<td><%=std.Surname%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} catch (Exception e) {
				out.println(e);
			}
		} //end if
		else if(request.getMethod().equalsIgnoreCase("GET")){			
			Vector<Bean> vect = db.getStudent();
	  %>
	<table width="350" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Father Name</th>
			<th>Surname</th>
		</tr>
		<%
		 for (Bean std : vect) {
		%>
		<tr>
			<td><%=std.Id%></td>
			<td><%=std.Name%></td>
			<td><%=std.Fname%></td>
			<td><%=std.Surname%></td>
		</tr>
		<%
		  }
		 %>
	</table>
	<%		
		}
		
	else { out.println("----------------------------"); } %>
</body>
</html>