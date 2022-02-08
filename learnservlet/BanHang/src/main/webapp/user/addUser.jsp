<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Cookie cookie[] = request.getCookies();
 for(Cookie c : cookie){
	 if(c.getName().equals("name")){
		 String value = c.getValue();
		%>
		<h1>value: <%=value %></h1>
		<%
	 }
 }
%>
<h1>them nguoi dung moi</h1>
<form action="viewUser.jsp" method="post">
<input name="name" type="text" placeholder="ten nguoi dung">
<input name="password" type="password" placeholder="mat khau">
<input name="phone" type="text" placeholder="dien thoai">
<textarea rows="3" cols="3" name="about" placeholder="gioi thieu"></textarea>
<input type="submit" value="add">
</form>
</body>
</html>