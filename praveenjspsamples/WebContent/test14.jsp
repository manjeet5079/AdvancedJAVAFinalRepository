<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int day =3; %>
Switch Statement is used. <br>
<%
switch(day) {
case 1:
out.println("Day 1");
break;
case 2:
out.println("Day 2");
break;
case 3:
out.println("Day 3");
break;
default:
out.println("Some other day");
}
%>
</body>
</html>