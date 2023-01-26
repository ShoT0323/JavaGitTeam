<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Locker" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>承認</title>
</head>
<body>
<%
		Locker account = (Locker)session.getAttribute("input");
	%>
	<%=account.getLockerno() %>
	名前：<%=account.getName() %><br>
	メール：<%=account.getMail() %><br>
	パスワード：********<br>
<a href="RegisterExecute">OK</a><br>
<a href="RegisterForm">戻る</a>
</body>
</html>