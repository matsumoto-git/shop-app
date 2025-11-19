<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>
</head>
<body>
<h1>ようこそ</h1>
<!-- エラー表示 -->
<% String error = (String)request.getAttribute("error"); %>
<% if(error != null) { %>
<p style="color:red;"><%= error %></p>
<% } %>
<!-- ログインフォーム -->
<form action="Login" method="post">
メールアドレス：<input type="email" name="mail"><br>
パスワード：<input type="password" name="password"><br>
<input type="submit" value="ログイン">
</form>
<br><br>
<p>アカウント作成は<a href="<%= request.getContextPath() %>/UserRegister">こちら</a><br><br>
<a href="<%= request.getContextPath() %>/main">ログインせずに商品一覧を見る</a>

</body>
</html>