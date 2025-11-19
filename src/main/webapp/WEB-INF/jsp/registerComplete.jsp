<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
<h2><%= request.getAttribute("userName") %> さん、登録完了しました！</h2>
<p>ログインは<a href="<%= request.getContextPath() %>/index.jsp">こちら</a></p>
</body>
</html>