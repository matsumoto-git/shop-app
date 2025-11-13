package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items = new ArrayList<>();
	
//	すでに同じ商品があれば数量を加算
//	なければ新しくCartItemを追加
	public void addItem(Product product, int quantity) {
		for(CartItem item : items) {
			if(item.getProduct().getId() == product.getId()) {
				item.setQuantity(item.getQuantity() + quantity);
				return;
			}
		}
		items.add(new CartItem(product, quantity));
	}
//	カートの中身を取得
	public List<CartItem> getItems() {
		return items;
	}
//	削除
	public void removeItem(int productId) {
		items.removeIf(item -> item.getProduct().getId() == productId);
	}

}
