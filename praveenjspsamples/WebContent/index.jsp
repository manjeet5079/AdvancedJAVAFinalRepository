<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<jsp:include page="display.jsp"> 
<jsp:param name="userid" value="Praveen" /> 
<jsp:param name="password" value="Praveen" /> 
<jsp:param name="name" value="Praveen Oruganti" /> 
<jsp:param name="age" value="32" /> 
</jsp:include> 
</body>
</html>