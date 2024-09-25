package com.nt;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.dao.EmployeeDao;

@SpringBootApplication
public class BootProj02AutoConfigurationsApplication {
	
//	@Bean
//	public DataSource createDs()throws Exception{
//		ComboPooledDataSource cds=new ComboPooledDataSource();
//		cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
//		cds.setJdbcurl("jdbc:oracle:thin:@localhost:1521:xe");
//		cds.setuser("system");
//		cds.setPassword("Admin");
//		return cds;
//	}

	public static void main(String[] args) {
		
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj02AutoConfigurationsApplication.class, args);
		//get DAO class object reference 
		EmployeeDao dao=ctx.getBean("empDAO",EmployeeDao.class);
		//invoke the b.method
		try {
			System.out.println("emps count is::"+dao.getsEmployeeCount());
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
		//close the container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
