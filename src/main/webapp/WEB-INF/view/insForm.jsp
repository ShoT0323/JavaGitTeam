<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録</title>
</head>
<body>
      <form action="Insert" method="post">	
	  ロッカー番号:<input type="text" name="number"><br>
	  使用可能:<input type="radio" name="use" value="0">
	  使用不可:<input type="radio" name="use" value="1"><br>
	  <input type="submit" value="登録" >
      </form>

</body>
</html>