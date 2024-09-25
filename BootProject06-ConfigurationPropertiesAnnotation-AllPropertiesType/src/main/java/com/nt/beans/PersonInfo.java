package com.nt.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;



@Data
@Component("pInfo")
@ConfigurationProperties(prefix="per.info")
public class PersonInfo {
	
	//simple wrapper class type
	private Integer pid;
	private String pname;
	//array type
	private String[] favColors;
	//List-collection type
	private List<String> studies;
	//Set collection type
	private Set<Long> phoneNo;
	//Map collection type
	private Map<String,Object> idDetails;
	
	//HAS-A property(Composition)
	private JobDetails jobInfo;

	
	@Override
	public String toString() {
		System.out.println("PersonInfo.toString()");
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", favColors=" + Arrays.toString(favColors)
				+ ", studies=" + studies + ", phoneNo=" + phoneNo + ", idDetails=" + idDetails + ", jobInfo=" + jobInfo
				+ "]";
	}
	
	

}
