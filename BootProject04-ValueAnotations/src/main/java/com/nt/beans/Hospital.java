package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hsptl")
@Data
@PropertySource("classpath:input.properties")
public class Hospital {
	
	@Value("KIMS")//hard coading
	private String name;
	@Value("30")
	private int rank;
	
	@Value("${hsptl.name}") //collecting properties file
	private String name1;
	
	@Value("${hsptl.age}")
	private int age;
	
	@Value("${Path}")//injecting from env.. variable
	private String path;
	
	@Value("${os.name}") //injection system property value
	private String os;
	
	
	//@Autowired //Autowired injection for object type injections
	@Value("#{info}")//using SPEL performing injection to object type property
	private LabTestInfo linfo;//HAS-A property
	
	@Value("#{info.bloodprofileprice+info.rtpcrPrice+info.echo2Dprice}")  //SPEL based arithmetic operation and injection
	private float labTestBillAmt;
	

}
