package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;


@Controller("empControl")
public class PayRollControlSystem {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	
	
	public PayRollControlSystem() {
		System.out.println("PayRollControlSystem::0-param constructor");
	}



	public List<Employee> showEmpDetailsByDesg(String desg1,String desg2,String desg3)throws Exception{
		//use service
		List<Employee> listemp=service.fetchEmpDetailsByDesg(desg1, desg2, desg3);
		return listemp;
		
	}

}
