package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.beans.Hospital;

@SpringBootApplication
public class BootProject04ValueAnotationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProject04ValueAnotationsApplication.class, args);
	
		//get spring bean class object
		Hospital hospital=ctx.getBean("hsptl",Hospital.class);
		//invoke the b.method
		System.out.println("spring bean class object data::"+hospital);
		
		//close container
		((ConfigurableApplicationContext)ctx).close();
		
		System.out.println("=======================================");
		//System.out.println("system properties"+System.getProperties());
		
		Environment env=ctx.getEnvironment();
		System.out.println("env object data ::"+env.toString());
		System.out.println("os.name value="+env.getProperty("os.name"));
		System.out.println("hsptl.name key's value::"+env.getProperty("hsptl.name"));
		
	}

}
