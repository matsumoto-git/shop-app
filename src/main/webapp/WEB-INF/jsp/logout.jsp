<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト</title>
</head>
<body>
<h2>ログアウトしました</h2>
<a href="<%= request.getContextPath() %>/index.jsp">ログイン画面へ</a><br><br>
<a href="<%= request.getContextPath() %>/main">商品一覧へ</a>
</body>
</html>