package siva.DAO;

import java.util.List;
import java.util.function.Supplier;

import javax.management.Query;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SupplierDAOImpl  
{
  @Autowired
  SessionFactory sessionFactory;

public boolean addSupplier(Supplier supplier) {
	try
	{
		sessionFactory.getCurrentSession().save(supplier);
		return true;
	}
	catch(Exception e)
	{
	return false;
	}
}

public boolean deleteSupplier(Supplier supplier) {
	try
	{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}
	catch(Exception e)
	{
	return false;
	}
	
}

public boolean updateSupplier(Supplier supplier) {
	try
	{
		sessionFactory.getCurrentSession().update(supplier);
		return true;
	}
	catch(Exception e)
	{
	return false;
	}
}

public List<Supplier> listSuppliers() {
	org.hibernate.Session session=sessionFactory.openSession();
	org.hibernate.query.Query query=session.createQuery("from Supplier");
	List<Supplier>listSuppliers=query.list();
	session.close();
	
	return listSuppliers;
}
}
