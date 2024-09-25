package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.Vehicle;
import com.nt.config.AppConfig;

public class StartegyDpTest {

	public static void main(String[] args) {

		//create ioc container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get target class object
		Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		//invoke method
		vehicle.journey("delhi", "london");
		//close container
		ctx.close();
		
	}

}
