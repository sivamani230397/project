package siva.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import siva.model.CartItem;

public class CartDAOImp {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public boolean deleteCartItem(CartItem cartItem)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean updateCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public List<CartItem> retrieveCartItems(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where username=:uname and pstatus='NP'");
		query.setParameter("uname", username);
		List<CartItem> listCartItem=query.list();
		session.close();
		return listCartItem;
	}

	
	public CartItem getCartItem(int cartItemId) 
	{
		Session session=sessionFactory.openSession();
		CartItem cartItem=session.get(CartItem.class,cartItemId);
		session.close();
		return cartItem;
	}
	

}
