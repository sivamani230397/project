package siva.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import siva.dao.ProductDao;
import siva.model.Category;
import siva.model.Product;

public class ProductDaoTest 
{

static ProductDao productDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("siva");
		context.refresh();
		productDao=(ProductDao)context.getBean(ProductDao.class);
	}
	
	//@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductname("Test Bike");
		product.setProductDescription("A test bike to test ride.");
		product.setQuantity(10);
		product.setPrice(34000);
		product.setQuantity(1);
		
		assertTrue("Problem in adding Product", productDao.saveOrUpdateProduct(product));
	}
	
	@Ignore
	@Test
	public void deleteProduct()
	{
		assertTrue("Problem in deleting Product", productDao.deleteProduct(33));
	}
	
	@Ignore
	@Test
	public void updateProduct()
	{
		Product product = productDao.getProduct(35);
		product.setProductname("Update Bike");
		product.setProductDescription("An updated bike to test ride.");
		product.setQuantity(1001);
		product.setPrice(55000);
		product.setQuantity(6);
		
		assertTrue("Problem in updating Product", productDao.saveOrUpdateProduct(product));
	}

}
