<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイトル</title>
</head>
<body>
<h1>ようこそ</h1>
<form action="Login" method="post">
メールアドレス：<input type="email" name="mail"><br>
パスワード：<input type="password" name="password"><br>
<input type="submit" value="ログイン"><br><br>
<a href="<%= request.getContextPath() %>/main">ログインせずに商品一覧を見る</a>
</form>
</body>
</html>