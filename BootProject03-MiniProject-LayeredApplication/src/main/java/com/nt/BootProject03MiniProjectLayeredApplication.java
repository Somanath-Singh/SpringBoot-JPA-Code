package com.nt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayRollControlSystem;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProject03MiniProjectLayeredApplication {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext ctx=SpringApplication.run(BootProject03MiniProjectLayeredApplication.class, args);
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
