package siva.test2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import siva.DAO.CategoryDAO;
import siva.DAO.SupplierDAO;
import siva.model.Category;
import siva.model.Supplier;

public class SupplierDAOTest {
	 static SupplierDAO supplierDAO;
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("siva");
			context.refresh();
		    supplierDAO=(SupplierDAO)context.getBean("SupplierDAO");
		}
	
		//@Ignore
	    @Test
	    public void addSupplierTest()
	    {
	    	Supplier supplier=new Supplier();
	    	supplier.setSupplierName("Akash");
	        supplier.setAddress("America");
	        supplier.setSupplierName("Manish");
	        supplier.setAddress("India");
	        assertTrue("Problem in Adding Supplier:",supplierDAO.addSupplier(supplier));
	    }
		@Ignore
	    @Test
	    public void updateSupplierTest()
	    {
	    	Supplier supplier=supplierDAO.getSupplier(3);
	    	supplier.setSupplierName("Manish");
	        supplier.setAddress("India");
	        assertTrue("Problem in updating the Supplier:",supplierDAO.updateSupplier(supplier));
	    }
	    @Ignore
	    @Test
	    public void deleteSupplierTest()
	    {
	    	Supplier supplier=supplierDAO.getSupplier(2);
	        supplier.setAddress("England");
	        assertTrue("Problem in deleting the Supplier:",supplierDAO.deleteSupplier(supplier));
	    }
	    
	    @Ignore
	    @Test
	    public void listSuppliersTest()
	    {
	    	List<Supplier>listSuppliers=supplierDAO.listSuppliers();
	    	assertNotNull("Problem in listing supppliers",listSuppliers);
	    	for(Supplier supplier:listSuppliers)
	    	{
	    		System.out.print(supplier.getSupplierId()+":::");
	    		System.out.print(supplier.getSupplierName()+":::");
	    		System.out.print(supplier.getAddress());
	    	}
	    		
	    	
	    }


}
