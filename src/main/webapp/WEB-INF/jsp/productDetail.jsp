<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ include file="/WEB-INF/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
<style>
.detail {
	padding: 20px;
	background-color: #fff;
	border: 1px solid #ccc;
	width: 400px;
	margin: auto;
}

img {
	width: 100%;
}
</style>
</head>
<body>
	<h2>商品詳細</h2>
	<%
	Product p = (Product) request.getAttribute("product");
	if (p != null) {
	%>
	<div class="detail">
		<img src="<%=p.getImagePath()%>" alt="商品画像">
		<h3><%=p.getName()%></h3>
		<p><%=p.getDescription()%></p>
		<p>
			価格：¥<%=p.getPrice()%></p>
		<form action="<%=request.getContextPath()%>/AddToCart" method="post">
			<input type="hidden" name="productId" value="<%=p.getId()%>">
			<label>数量：</label> <input type="number" name="quantity" value="1"
				min="1"><br>
			<br> <input type="submit" value="カートに追加">
		</form>

	</div>

	<%
	} else {
	%>
	<p>商品が見つかりませんでした。</p>
	<%
	}
	%>

</body>
</html>