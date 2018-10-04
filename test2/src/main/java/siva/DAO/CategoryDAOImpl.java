package siva.DAO;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import siva.model.Category;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	 @Autowired
	    SessionFactory sessionFactory;
	    
		
		public boolean addCategory(Category category) {
			try
			{
				System.out.println("Entering add Category");
				Session session = sessionFactory.getCurrentSession();
				
				session.save(category);
				System.out.println("Inserted category successfully");
				//session.close();
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Insert category failed");
			return false;	
			}
		}

		
		public boolean deleteCategory(Category category) {
			try
			{
				sessionFactory.getCurrentSession().delete(category);
			return true;
			}
			catch(Exception e)
			{
			
			return false;
		    }
		}

		
		public boolean updateCategory(Category category) {
			try
			{
				sessionFactory.getCurrentSession().update(category);
			return true;
			}
			catch(Exception e)
			{
			return false;
		    }
		}	

		
		public List<Category> listCategories() {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Category");
			List<Category>listcategories=query.list();
			session.close();
			return listcategories;
		}

		
		public Category getCategory(int categoryId) {
			Session session=sessionFactory.openSession();
			Category category=(Category)session.get(Category.class, categoryId);
			session.close();
			return category;
		}
		
}
