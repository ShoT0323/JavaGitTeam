<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Locker"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
     request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
	  Locker ac= (Locker)session.getAttribute("input");
%>
        <p>登録に失敗しました。</p>
		<h3>新規登録</h3>
		<form action="Register" method="post">
		    ロッカー番号:<input type="text" name="number"> 
		    名前：<input type="text" name="name" value="<%=ac.getName()%>"><br>
		    メール：<input type="email" name="email" value="<%=ac.getMail()%>"><br>
			パスワード：<input type="password" name="pw"><br>
		    <input type="submit" value="登録">
		</form>
<%
		} else {
%>
     	<h3>新規登録</h3>
	    <form action="Register" method="post">
	        名前：<input type="text" name="name"><br>
	        メール：<input type="email" name="email"><br>
	        パスワード：<input type="password" name="pw"><br>
	        <input type="submit" value="登録">
	    </form>
<%
		}
%>

</body>
</html>