<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<%
	model.User loginUser = (model.User) session.getAttribute("loginUser");
	if (loginUser != null) {
	%>
	<span style="color:white; margin-right: 10px;">
	<%= loginUser.getEmail() %> さんがログイン中
	</span>
	<a href="<%= request.getContextPath() %>/Logout" class="header-button">ログアウト</a>
	<a href="<%= request.getContextPath() %>/CartView" class="header-button">カート</a>
	<a href="<%= request.getContextPath() %>/main" class="header-button">メイン画面へ</a>
	
	<%
	} else {
	%>
	<a href="<%= request.getContextPath() %>/index.jsp" class="header-button">ログインする</a>
	<a href="<%= request.getContextPath() %>/CartView" class="header-button"> カート</a>
	<a href="/shop/main" class="header-button"> 商品一覧</a>
	<% } %>
</div>
<style>
.header {
	background-color: #333;
	padding: 10px;
	text-align: right;
}

.header-button {
	color: white;
	text-decoration: none;
	background-color: black;
	padding: 8px 12px;
	border-radius: 5px;
	font-weight: bold;
	margin-left: 10px;
}

.header-button:hover {
	background-color: gray;
}
</style>