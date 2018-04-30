<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 2px;
}

a {
	color: #005b7f;
	text-decoration: underline;
	font-weight: bolder;
}
</style>
</head>
<body>

	<form action="updateEmp" method="get">
		<table align="center">
		    <tr>
				<td>Emp Id :</td>
				<td><input type="text" name="eid" value="${emp.eid}" readonly/>
			</tr>
			<tr>
				<td>Emp Name :</td>
				<td><input type="text" name="ename" value="${emp.ename}" ="required" />
			</tr>
			<tr>
				<td>Emp Salary :</td>
				<td><input type="text" name="esal" value="${emp.salary}" required="required" />
			</tr>
			<tr>
				<td>Emp Email :</td>
				<td><input type="text" name="email" value="${emp.email}" required="required" />
			</tr>

			<tr>
				<td></td>			
				<td><input type="reset" value="Reset" required="required" /> <input
					type="submit" value="Update" /></td>
					
					
			</tr>
		</table>
	</form>


</body>
</html>
