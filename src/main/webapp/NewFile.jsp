<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String email=request.getParameter("validate");
if(email==null||email.trim().equals(""))
{  
	out.print("<p>Please Enter First Name!</p>");  
}
else{
     try{ 
     		Class.forName("com.mysql.jdbc.Driver");
     		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_5","root","");  
     		PreparedStatement ps=con.prepareStatement("select * from contact where name like '"+email+"%'");  
     		ResultSet rs=ps.executeQuery();  
       		if(rs.isBeforeFirst()) 
       		{
     			out.print("<table border='5' cellpadding='5' width='100%'>");  
     			out.print("<tr><th>Id</th><th>Name</th><th>Subject</th><th>Email</th><th>Phone</th><th>Message</th></tr>");  
     			while(rs.next())
     			{  
     				out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");  
     			}  
     			out.print("</table>");  
       		}
     		con.close();  
     }
     catch(Exception e)
 	{
 		out.print(e);
 	}  
     
	
	
}
%> 

</body>
</html>