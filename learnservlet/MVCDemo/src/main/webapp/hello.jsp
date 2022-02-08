<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page 
import="com.truongjae.model.User"
import="java.util.ArrayList"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
xin chao dcmm
<%
ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listuser");
for(User user : listUser){
	%>
	id: <td><%=user.getId() %></td>
	name: <td><%=user.getName() %></td> <br>
	<%
}
%>

</body>
</html>