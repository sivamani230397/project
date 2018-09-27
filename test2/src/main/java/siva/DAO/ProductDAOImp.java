package siva.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import siva.model.Product;

public class ProductDAOImp implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;

	
	public boolean addProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	
	public boolean updateProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	
	public List<Product> listProducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product>listProducts=query.list();
		session.close();
		return listProducts;
	}

	public Product getProduct(int productId) {
	 Session session=sessionFactory.openSession();
	 Product product=session.get(Product.class,productId);
	 session.close();
		return product;
	}



}
