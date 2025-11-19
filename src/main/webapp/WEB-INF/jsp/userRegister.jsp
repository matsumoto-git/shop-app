<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h2>新規ユーザー登録</h2>
<!-- メールアドレス重複時のエラー表示 -->
<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
	<p style="color:red;"><%= error %></p>
<% } %>
<form action="<%= request.getContextPath() %>/UserRegister" method="post">
	名前：<input type="text" name="name" required><br>
	メール：<input type="email" name="email" required><br>
	パスワード：<input type="password" name="password" required><br>
	<input type="submit" value="登録">
</form>
<br><br>
<a href="<%= request.getContextPath() %>/index.jsp">トップページへ戻る</a>
</body>
</html>