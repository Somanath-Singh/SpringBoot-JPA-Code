package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Employee;

@SpringBootApplication
public class BootProject05ConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=SpringApplication.run(BootProject05ConfigurationPropertiesAnnotationApplication.class, args);
		//get spring bean class object
//		CustomerInfo cust=ctx.getBean("custinfo",CustomerInfo.class);
		Employee emp=ctx.getBean("empDetails",Employee.class);
		//invoke the business method
		//System.out.println("Customer info"+cust);
		System.out.println("Employee info"+emp);
		
		//close the ioc container
		((ConfigurableApplicationContext) ctx).close();
	}

}
