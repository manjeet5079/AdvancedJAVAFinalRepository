<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1 {
	color: lime;
	background-color: gray;
	font-family: sans-serif;
	font-size: medium;
	text-align: center;
	text-transform: uppercase;
}
</style>

<script type="text/javascript">
	function validateLoginDetails()
	{
		if (document.loginForm.userName.value == "") {
			document.getElementById("namError").innerHTML = "<font color='red'>User Name is Mandatory</font>";
			return false;
		}
		if (document.loginForm.password.value == "") {
			document.getElementById("passError").innerHTML = "<font color='red'>Password is Mandatory</font>";
			return false;
		}
		return true;
	}
</script>

</head>
<body onload="document.loginForm.userName.focus()">

	<h1>Login Page</h1>
	<form action="loginAdmin" name="loginForm"
		onsubmit="return validateLoginDetails();" method="POST">
		<pre>
	User Name : <input type="text" name="userName" id="userName"><span
				id="namError"></span>
	Password  : <input type="password" name="password" id="password"><span
				id="passError"></span>
	<input type="submit" value="Login"><input type="reset"
				value="Clear">
</pre>
	</form>
	<%
		if (request.getParameter("msg") != null) {
			out.print("<font color='red'>" + request.getParameter("msg") + "</font>");
		}
	%>
</body>

</html>