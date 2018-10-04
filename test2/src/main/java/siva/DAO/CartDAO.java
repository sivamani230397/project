package siva.DAO;

import java.util.List;

import siva.model.CartItem;

public interface CartDAO {
	public boolean addCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public List<CartItem> retrieveCartItems(String username);
	public CartItem getCartItem(int cartItemId);

	

}
