package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("empDetails")
@ConfigurationProperties(prefix="emp.details")
@Data
public class Employee {

	//spring bean properties
	@Value("${emp.info.name}")
	private String name;
	private int age;
	
	public Employee() {
		System.out.println("Employee.Employee()::0-param constructor "+name);
	}
	
	public void setName(String name) {
		
		System.out.println(this.name);
		System.out.println("Employee.setName() "+name);
		this.name=name;
		
	}
	
}
