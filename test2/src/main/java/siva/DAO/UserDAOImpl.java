package siva.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import siva.model.User;

public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean registerUser(User user) {
		try
		{
			System.out.println("im in userdao");
			sessionFactory.getCurrentSession().save(user);
			System.out.println("saved user successfully");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("user failed");
		return false;
		}
	}

	public boolean modifyUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Update failed");
		return false;
		}
	}

	public User getUser(String username) {
		org.hibernate.Session session=sessionFactory.openSession();
		User user=session.get(User.class,username);
		session.close();
		return user;
	}

}


