package com.nt.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="per.info")
@Component("job")
public class JobDetails {
	
	private String desg;
	private String company;
	private Integer deptno;
	private Integer salary;

}
