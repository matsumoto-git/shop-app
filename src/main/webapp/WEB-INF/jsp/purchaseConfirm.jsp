<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cart, model.CartItem, java.util.List"%>
<%@ include file="/WEB-INF/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認</title>
</head>
<body>
<h2>購入確認</h2>
<%
Cart cart = (Cart) request.getAttribute("cart");
if(cart != null && !cart.getItems().isEmpty()) {
	List<CartItem> items = cart.getItems();
%>
<ul>
	<% for (CartItem item : items) { %>
		<li><%= item.getProduct().getName() %> × <%= item.getQuantity() %></li>
	<% } %>
</ul>
<form action="<%= request.getContextPath() %>/PurchaseComplete" method="post">
	<input type = "submit" value = "購入を確定する">
</form>
<% } else { %>
	<p>カートは空です</p>
<% } %>
</body>
</html>