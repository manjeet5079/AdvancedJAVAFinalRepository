<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print("Welcome in JSP");
	%>

	<form action="response.jsp" method="post">
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
				<td colspan="2"><center>
						<input name="" type="submit">
					</center></td>
			</tr>
		</table>
	</form>
</body>
</html>