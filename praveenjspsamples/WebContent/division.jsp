<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Division Calculation Page</title>
</head>
<body>
<%@ page errorPage="exception.jsp" %> 
<% 
String num1=request.getParameter("firstnum"); 
String num2=request.getParameter("secondnum"); 
int v1= Integer.parseInt(num1);
int v2= Integer.parseInt(num2);
double res= (double)v1/v2;
out.print("Output is: "+ res);
%>
</body>
</html>