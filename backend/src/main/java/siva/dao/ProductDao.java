package siva.dao;

import java.util.List;

import siva.model.Category;
import siva.model.Product;


public interface ProductDao {
	

	List<Product> getAllProducts(); //select * from product
	Product getProduct(int id);
	boolean deleteProduct(int id); //delete from product where id=?
	List<Category> getCategories();
	boolean saveOrUpdateProduct(Product product);

	
	
}





