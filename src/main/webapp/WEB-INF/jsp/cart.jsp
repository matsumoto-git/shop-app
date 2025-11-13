<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Cart, model.CartItem, java.util.List"%>
<%@ include file="/WEB-INF/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カートの中身</title>
<style>
.cart-table {
	width: 80%;
	margin: auto;
	border-collapse: collapse;
}

.cart-table th, .cart-table td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}
</style>
</head>
<body>
	<h2> カートの中身</h2>
	<%
	Cart cart = (Cart) request.getAttribute("cart");
	if (cart != null && !cart.getItems().isEmpty()) {
		List<CartItem> items = cart.getItems();
	%>
	<table class="cart-table">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>数量</th>
			<th>小計</th>
		</tr>
		<%
		int total = 0;
		for (CartItem item : items) {
			int subtotal = item.getProduct().getPrice() * item.getQuantity();
			total += subtotal;
		%>
		<tr>
			<td><%=item.getProduct().getName()%></td>
			<td>¥<%=item.getProduct().getPrice()%></td>
			<td><%=item.getQuantity()%></td>
			<td>¥<%=subtotal%></td>
			<td>
				 <form action="<%= request.getContextPath() %>/RemoveFromCart" method="post">
      			 	<input type="hidden" name="productId" value="<%= item.getProduct().getId() %>">
      			 	<input type="submit" value="削除">
				</form>
			</td>
		</tr>
		<%
		}
		%>
		<tr>
			<td colspan="3"><strong>合計</strong></td>
			<td><strong>¥<%=total%></strong></td>
		</tr>
	</table>
	<form action="<%= request.getContextPath() %>/PurchaseConfirm" method="post" style="text-align:center; margin-top:40px;">
  		<input type="submit" value="購入へ進む">
	</form>
	<%
	} else {
	%>
	<p>カートは空です。</p>
	<%
	}
	%>
</body>
</html>