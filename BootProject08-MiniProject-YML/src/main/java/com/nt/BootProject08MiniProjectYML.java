package com.nt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayRollControlSystem;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProject08MiniProjectYML {
	
	
	@Bean(name="c3poDs")
	@Profile("uat")
	public ComboPooledDataSource createC3PODs()throws Exception{
		
		System.out.println("BootProject08MiniProjectProfiles.createC3PODs()");
		
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cds.setUser("system");
		cds.setPassword("Admin");
		return cds;
	}

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext ctx=SpringApplication.run(BootProject08MiniProjectYML.class, args);
		
		
		//another way/ springboot way to active profiles
//		SpringApplication application=new SpringApplication(BootProject08MiniProjectYML.class);
//		application.setAdditionalProfiles("dev","test");
//		ApplicationContext ctx=application.run(args);
		
		
		//get controller class object
		PayRollControlSystem controller=ctx.getBean("empControl",PayRollControlSystem.class);
		
		//get inputs from end user
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter desg1");
		String desg1=sc.next().toUpperCase();
		System.out.println("Enter desg2");
		String desg2=sc.next().toUpperCase();
		System.out.println("Enter desg3");
		String desg3=sc.next().toUpperCase();
		
		//invoke b.method
		try {
			List<Employee> listemps=controller.showEmpDetailsByDesg(desg1, desg2, desg3);
			
			listemps.forEach(emp->
			System.out.println(emp)
			);
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			System.out.println("Internal DB problem");
		}
		catch(Exception se) {
			se.printStackTrace();
			System.out.println("Internal unknown problem");
		}
		
		//close the container
		((ConfigurableApplicationContext) ctx).close();
		
	}
	

}
