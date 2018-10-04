package siva.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import siva.model.CartItem;
import siva.model.Category;
import siva.model.Product;
import siva.model.Supplier;
import siva.model.User;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		System.out.println("Datasource");
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/myDB/Project1DB");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}
	
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	System.out.println("SessionFactory");
  Properties hibernateProperties=new Properties();
  hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
  hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
  
   LocalSessionFactoryBuilder localSessionFactory=new LocalSessionFactoryBuilder(getH2DataSource());
   localSessionFactory.addProperties(hibernateProperties);
   
   Class classes[] = new Class[] {Category.class,Product.class,User.class,Supplier.class, CartItem.class};
   
   localSessionFactory.addAnnotatedClasses(classes);
   
   SessionFactory sessionFactory=localSessionFactory.buildSessionFactory();
   
   return (SessionFactory) sessionFactory;
}

@Bean(name="transactionManager")
public HibernateTransactionManager getHibernateTransactionmanager(SessionFactory sessionFactory)
{
	System.out.println("HibTxnMgr");
	return new HibernateTransactionManager (sessionFactory);
}
		
	}
