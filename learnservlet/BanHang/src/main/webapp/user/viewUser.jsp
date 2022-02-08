<%@page import="com.truongjae.ListUser"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");
String password = request.getParameter("password");
String phone = request.getParameter("phone");
String about = request.getParameter("about");
%>
<table>
<tr>
	<td>ten</td>
	<td><%=name %></td>
</tr>
<tr>
	<td>password</td>
	<td><%=password %></td>
</tr>
<tr>
	<td>phone</td>
	<td><%=phone %></td>
</tr>
<tr>
	<td>about</td>
	<td><%=about %></td>
</tr>

<%
String username = (String)session.getAttribute("name");
%>
<h2>session<%=username %></h2>

<%
ListUser list = new ListUser();
ArrayList<ListUser> listuser = list.list();
%>
<%for(ListUser l : listuser){ %>
<tr>
<td>id<%=l.getId() %></td>
<td>ten<%=l.getName() %></td>
</tr>
<%} %>
</table>


<%
Cookie cookie = new Cookie("name","truongjae");
response.addCookie(cookie);

%>


</body>
</html>