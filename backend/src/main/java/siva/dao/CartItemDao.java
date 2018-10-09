package siva.dao;

import siva.model.Cart;
import siva.model.CartItem;
import siva.model.CustomerOrder;

public interface CartItemDao {
	
	void saveOrUpdateCartItem(CartItem cartItem);
	
	void removeCartItem(int cartItemId);
	
	Cart getCart(int cartId);
	
	CustomerOrder createOrder(Cart cart);

}
