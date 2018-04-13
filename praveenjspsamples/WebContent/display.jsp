<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Page</title>
</head>
<body>
UserID: <%=request.getParameter("userid") %><br>
Password is: <%=request.getParameter("password") %><br>
User Name: <%=request.getParameter("name") %><br>
Age: <%=request.getParameter("age") %>
</body>
</html>