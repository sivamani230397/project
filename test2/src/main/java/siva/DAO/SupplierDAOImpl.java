package siva.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import siva.model.Supplier;
@Repository("SupplierDAO")
@Transactional


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
