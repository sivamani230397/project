package siva.test2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import siva.DAO.UserDAO;
import siva.model.User;

public class UserDAOTest {
	static UserDAO userDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("siva");
		context.refresh();
	    userDAO=(UserDAO)context.getBean("UserDAO");
	}
	@Ignore
    @Test
    public void registerUserTest()
    {
    	User user=new User();
    	user.setUsername("Manish");
        user.setPassword("mani");
        user.setCustomerName("Praveen");
        user.setMobileNumber("8667226314");
        user.setEmailId("Manish30@gmail.com");
        user.setRole("Admin");
        user.setEnabled("enable");
        assertTrue("Problem in Adding User:",userDAO.registerUser(user));
    }
    //@Ignore
    @Test
    public void modifyUserTest()
    {
    	User user=userDAO.getUser("Manish");
    	user.setUsername("Akash");
        user.setPassword("pavan");
        user.setCustomerName("Arjun");
        user.setMobileNumber("98414013");
        user.setEmailId("Arjun@gmail.com");
        user.setRole("Admin");
        user.setEnabled("enable");
        assertTrue("Problem in modifying the User:",userDAO.modifyUser(user));
    }
   



}
