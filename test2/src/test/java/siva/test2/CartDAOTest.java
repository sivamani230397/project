package siva.test2;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import siva.DAO.CartDAO;
import siva.model.CartItem;

public class CartDAOTest {
static CartDAO cartDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("siva");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Ignore
	@Test
	public void addCartItemTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setProductId(13);
		cartItem.setProductName("NokiaX");
		cartItem.setQuantity(10);
		cartItem.setPrice(7200);
		cartItem.setUsername("Akash");
		cartItem.setPstatus("NP");
		
		assertTrue("Problem in Adding the Cart Item:",cartDAO.addCartItem(cartItem));
	}
	
	@Test
	public void retrieveCartItemTest()
	{
		List<CartItem> listCartItems=cartDAO.retrieveCartItems("Akash");
		
		assertTrue("Problem in Retrieving the Cart Items:",listCartItems.size()>0);
		
		for(CartItem cartItem:listCartItems)
		{
			System.out.print(cartItem.getProductName()+":::");
			System.out.print(cartItem.getQuantity()+":::");
			System.out.println(cartItem.getProductId());
		}
	}



}
