package siva.test2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import siva.DAO.CategoryDAO;
import siva.model.Category;

public class CategoryDAOTest {
	
	@Autowired
    static CategoryDAO categoryDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("siva");
		context.refresh();
	    categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");
	}
    @Test
    public void addCategoryTest()
    {
    	Category category=new Category();
    	category.setCategoryName("Sony");
        category.setCategoryDesc("All sony LED TV's");
        assertTrue("Problem in Adding Category:",categoryDAO.addCategory(category));
    }
//    @Ignore
    @Test
    public void updateCategoryTest()
    {
    	Category category=categoryDAO.getCategory(3);
    	category.setCategoryName("SivaColorBar");
        category.setCategoryDesc("All ColorBar products");
        assertTrue("Problem in updating the Category:",categoryDAO.updateCategory(category));
    }
  //  @Ignore
    @Test
    public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(39);
		assertTrue("Probem in deleting the Category",categoryDAO.deleteCategory(category));
	}
	  
    //@Ignore
    @Test
    public void listCategoriesTest()
    {
    	List<Category>listCategories=categoryDAO.listCategories();
    	assertNotNull("Problem in listing categories",listCategories);
    	for(Category category:listCategories)
    	{
    		System.out.print(category.getCategoryId()+":::");
    		System.out.print(category.getCategoryName()+":::");
    		System.out.print(category.getCategoryDesc());
    	}
    		
    	
    }


	}

