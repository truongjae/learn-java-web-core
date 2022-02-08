<%@page import="com.truongjae.utils.SessionUtil"%>
<%@page import="com.truongjae.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>
day la trang admin
<%
UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
if (userModel != null){
	%>
	<h1>welcome <%=userModel.getUserName() %></h1>
	<%
}
%>
<a href="http://localhost:8080/NewsJDBC/login?action=logout">thoat</a>
</body>
</html>