<%@page import="com.truongjae.model.UserModel"%>
<%@page import="com.truongjae.utils.SessionUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
day la trang user
<%
UserModel userModel = (UserModel) (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
if (userModel != null){
	%>
	<h1>welcome <%=userModel.getUserName() %></h1>
	<%
}
%>
<a href="http://localhost:8080/NewsJDBC/login?action=logout">thoat</a>
</body>
</html>