package siva.test2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import siva.DAO.ProductDAO;
import siva.model.Product;

public class ProductDAOTest {
	static ProductDAO productDAO;
	@BeforeClass
	public static void initialize()
	{
		System.out.println("Hello");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("siva");
		context.refresh();
	    productDAO=(ProductDAO)context.getBean("ProductDAO");
	}
    //@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("MAC matte-lipstick");
		product.setProductDesc("All MAC lipstick products");
		product.setQuantity(7);
		product.setPrice(950);
		product.setSupplierId(3);
		product.getCategoryId();
		assertTrue("Problem in adding Products",productDAO.addProduct(product));
		}
	//@Ignore
    @Test
    public void updateProductTest()
    {
    	Product product=productDAO.getProduct(1);
    	product.setProductName("Kilye");
        product.setProductDesc("All Kylie products");
        product.setQuantity(4);
        product.setPrice(1600);
        product.setSupplierId(3);
        product.getCategoryId();
        assertTrue("Problem in updating the Products:",productDAO.updateProduct(product));
    }
    @Ignore
    @Test
    public void deleteProductTest()
    {
    	Product product=productDAO.getProduct(2);
        assertTrue("Problem in deleting the Product:",productDAO.deleteProduct(product));
    }
    
    @Ignore
    @Test
    public void listProductsTest()
    {
    	List<Product>listProducts=productDAO.listProducts();
    	assertNotNull("Problem in listing products",listProducts);
    	for(Product product:listProducts)
    	{
    		System.out.print(product.getProductId()+":::");
    		System.out.print(product.getProductName()+":::");
    		System.out.print(product.getProductDesc()+":::");
    		System.out.print(product.getQuantity()+":::");
    		System.out.print(product.getPrice()+":::");
    		System.out.print(product.getSupplierId()+":::");
    		System.out.print(product.getCategoryId());
    		
    	}
    		
    	
    }


}