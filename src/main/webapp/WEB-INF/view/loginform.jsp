<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

		<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
		%>
			<p style="color:red">ログイン失敗</p>
			<form action="LoginServlet" method="post">
			【メールアドレスとPWを入力してください。】<br>
			メール：<input type="text" name="mail" value="<%=request.getParameter("mail") %>"><br>
			PW：<input type="password" name="pw"><br>
			<input type="submit" value="ログイン">
			<a href="./">戻る</a>
			</form>
		
		<%
			} else {
		%>
		
			<form action="LoginServlet" method="post">
			【メールアドレスとPWを入力してください。】<br>
			メール：<input type="text" name="mail"><br>
			PW：<input type="password" name="pw"><br>
			<input type="submit" value="ログイン">
			<a href="./">戻る</a>
			</form>
		
		<%
			}
		%>
		
</body>
</html>