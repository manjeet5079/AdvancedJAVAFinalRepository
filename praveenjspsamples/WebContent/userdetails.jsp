<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details Page</title>
</head>
<body>
<jsp:useBean id="userinfo" class="com.praveen.bean.Details"></jsp:useBean> 
<jsp:setProperty property="*" name="userinfo"/> 
You have enterted the below details:<br> 
<jsp:getProperty property="username" name="userinfo"/><br> 
<jsp:getProperty property="password" name="userinfo"/><br> 
<jsp:getProperty property="age" name="userinfo" /><br>
</body>
</html>