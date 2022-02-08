<%@page import="com.truongjae.model.NewsModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sach Bai Viet</title>
</head>
<body>
<%/*List<NewsModel> list =(List<NewsModel>) request.getAttribute("listNewsModel");
for(NewsModel news : list){
	Long id = news.getId();
	String title = news.getTitle();
	String content = news.getContent();
	*/
	%>
	<br>
	<%
//}
%>
<c:forEach var="newsModel" items="${listNewsModel}">
	${newsModel.id} - ${newsModel.title} - ${newsModel.content} <br>
</c:forEach>
</body>
</html>