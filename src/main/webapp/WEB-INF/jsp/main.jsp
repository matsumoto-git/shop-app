<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Product"%>
<%@ include file="/WEB-INF/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
<style>
body {
	font-family: sans-serif;
	background-color: #f9f9f9;
	margin: 20px;
}
h2 {
	color: #333;
}
.product-list {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
}
.product {
	background-color: #fff;
	border: 1px solid #ccc;
	padding: 10px;
	width: 200px;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
}
.product img {
	width: 100%;
	height: auto;
}
.product-name {
	font-weight: bold;
	margin-top: 10px;
}
.product-price {
	color: #e91e63;
}
</style>
</head>
<body>
<h1>ホーム</h1>
<h2>商品一覧</h2>

<div class="product-list">
<%
	List<Product> productList = (List<Product>) request.getAttribute("productList");
	if (productList != null && !productList.isEmpty()) {
		for (Product p : productList) {
%>
	<div class="product">
		<a href="<%= request.getContextPath() %>/ProductDetail?id=<%= p.getId() %>">
			<img src="<%= request.getContextPath() %>/<%= p.getImagePath() %>" alt="商品画像">
			<div class="product-name"><%= p.getName() %></div>
		</a>
		<div class="product-price">¥<%= p.getPrice() %></div>
		<div>在庫：<%= p.getStock() %></div>
	</div>
<%
		} // for閉じ
	} else {
%>
	<p>商品が登録されていません。</p>
<%
	} // if閉じ
%>
</div>
</body>
</html>