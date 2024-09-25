package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.WishMessegeGenerator;
import com.nt.config.AppConfig;

public class DependencyManagementTest {

	public static void main(String[] args) {
		
		//create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get target class object
		WishMessegeGenerator generator =ctx.getBean("wmg",	 WishMessegeGenerator.class);
		//invoke the business method
		String result=generator.generateWishMessege("Somanath");
		System.out.println("output::"+result);
		
		//close ioc container
		ctx.close();
		

	}

}
