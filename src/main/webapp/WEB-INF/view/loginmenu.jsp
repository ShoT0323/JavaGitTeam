<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Locker" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<%
		Locker lo = (Locker)session.getAttribute("user");
	%>
	<h3>管理システム</h3>
	<p>ようこそ<%=lo.getName() %>さん</p>
</body>
</html>