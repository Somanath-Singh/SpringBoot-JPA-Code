package com.nt;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessegeGenerator;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {

	
	public BootProj01DependencyInjectionApplication() {
		System.out.println("BootProj01DependencyInjectionApplication::0-param constructor");
	}
	
	
	@Bean(name="calc")
	public Calendar createCalendar() {
		System.out.println("BootProj01DependencyInjectionApplication.createCalendar()");
		return Calendar.getInstance();//return gregorianCalender class(Sub class of calendar) obj
	}
	
	
	public static void main(String[] args) {
		//Bootstrap /Boot spring boot App and get ioc container ref
		ApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		System.out.println("IOC container class name::"+ctx.getClass());
		System.out.println("==============================================");
		//get target class object
		WishMessegeGenerator generator=ctx.getBean("wmg",WishMessegeGenerator.class);
		//invoke b.method
		String result=generator.generateWishMessege("raja");
		System.out.println("Wish Messege::"+result);
		
		System.out.println("==============================================");
		//close the ioc container
		((ConfigurableApplicationContext)ctx).close();
		
		System.out.println("End of main()");
		
		
	}

}
