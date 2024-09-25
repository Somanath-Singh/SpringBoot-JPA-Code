package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //make the class configuration file
@ComponentScan(basePackages="com.nt.beans")
public class AppConfig {
	
	
	public AppConfig() {
		System.out.println("AppConfig.AppConfig()::0-param constructor");
	}
	
	
	@Bean(name="sysdate")  //make the method as spring bean
	public LocalDateTime createLDT() {
		System.out.println("AppConfig.createLDT()");
		return LocalDateTime.now();
	}

}
