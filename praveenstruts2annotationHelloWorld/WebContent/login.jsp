<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
</head>
<body>
<h3>Welcome User, please login below</h3>
<s:form action="login">
	<s:textfield name="name" label="User Name"></s:textfield>
	<s:textfield name="pwd" label="Password" type="password"></s:textfield>
	<s:submit value="Login"></s:submit>
</s:form>
</body>
</html>