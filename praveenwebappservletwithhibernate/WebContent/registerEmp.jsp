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
	<h3 align="center">Insert Employee Record</h3>
	<form action="insertEmp" method="post">
		<p align="center">
			<font color='green'>${succMsg}</font> <font color='red'>${errMsg}</font>
		<p>
		<table align="center">
			<tr>
				<td>Emp Name :</td>
				<td><input type="text" name="ename" required="required" />
			</tr>
			<tr>
				<td>Emp Salary :</td>
				<td><input type="text" name="esal" required="required" />
			</tr>
			<tr>
				<td>Emp Email :</td>
				<td><input type="text" name="email" required="required" />
			</tr>

			<tr>
				<td></td>
				<td><input type="reset" value="Reset" required="required" /> <input
					type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>
	<p align="center">
		<a href="viewEmpData">View All Employee Records</a>
	</p>

</body>
</html>
