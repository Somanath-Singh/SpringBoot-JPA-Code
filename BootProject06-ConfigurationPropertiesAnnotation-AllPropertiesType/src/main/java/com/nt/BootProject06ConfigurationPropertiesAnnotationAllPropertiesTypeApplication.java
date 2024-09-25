package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.PersonInfo;

@SpringBootApplication
public class BootProject06ConfigurationPropertiesAnnotationAllPropertiesTypeApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProject06ConfigurationPropertiesAnnotationAllPropertiesTypeApplication.class, args);
		//get spring bean class object
		PersonInfo person=ctx.getBean("pInfo",PersonInfo.class);
		//invoke b.method
		System.out.println("person object info::"+person);//toString method call automaticaly when we print object
		
		//close ioc container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
