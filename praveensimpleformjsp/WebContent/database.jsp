<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" errorPage="" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Form Page</title>
</head>
<body>
<%!
public class Bean{
public int Id;
public String Name;
public String Fname;
public String Surname;
}
public class Database {
Connection con;
public void init()throws Exception{
String url = "jdbc:mysql://localhost:3306/Praveen";
String user = "root";
String pass = "";
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Driver Loaded Sucessfully");
con = DriverManager.getConnection(url, user, pass);
System.out.println("Connection Created Sucessfully");
}//end init
public Vector<Bean> getStudent()throws SQLException{
Statement stat = null;
ResultSet result = null;
Vector<Bean> vect = new Vector<Bean>();
String query = "Select StudentId, StudentName, FatherName, surname from student";
try{
stat = con.createStatement();
result=stat.executeQuery(query);
while(result.next()){
Bean std = new Bean();
std.Id = result.getInt("StudentId");
std.Name = result.getString("StudentName");
std.Fname = result.getString("FatherName");
std.Surname = result.getString("surname");
vect.addElement(std);
}//end loop
}finally{
if(stat!=null) stat.close();
}
return vect;
}//end getStudent
public int addStudent(String name, String fname, String surname)throws SQLException{
Statement stat = null;
int rows=0;
String query = "insert into student (StudentName, FatherName, surname) VALUES('"+name+"','"+fname+"','"+surname+"')";
try{
stat = con.createStatement();
rows = stat.executeUpdate(query);
return rows;
}finally{
if(stat!=null) stat.close();
}
}//end insert
}//end class
%>
</body>
</html>