package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;


@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDao dao;
	
	
	
	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl::0-param constructor");
	}



	@Override
	public List<Employee> fetchEmpDetailsByDesg(String desg1, String desg2, String desg3) throws Exception {

		//use dao
		List<Employee> listemp=dao.getEmployeebyDesg(desg1, desg2, desg3);
		return listemp;
		
	}

}
