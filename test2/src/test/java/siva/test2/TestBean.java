package siva.test2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import siva.model.Category;

public class TestBean 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("siva");
		
		context.refresh();
		
		Category category=(Category)context.getBean("category");
		
		category.display();
		context.close();
		 
		
	}

}
