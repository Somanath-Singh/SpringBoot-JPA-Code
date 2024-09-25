package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component("empDAO")
public class EmployeeDao {

	private static final String GET_EMP_COUNT="SELECT COUNT(*) FROM EMP ";

	@Autowired
	private DataSource ds;//HAS-A property
	
	//METHOD WITH PERSISTANCE LOGIC
	public int getsEmployeeCount()throws Exception{
		System.out.println("Injected DataSource Class object"+ds.getClass());
		//get pooled jdbc con object
		Connection con=ds.getConnection();
		//create prepared Statement object having SQL query
		PreparedStatement ps=con.prepareStatement(GET_EMP_COUNT);
		//execute the query
		ResultSet rs=ps.executeQuery();
		//process the result set
		rs.next();
		int count=rs.getInt(1);
		//close the jdbc objects
		rs.close();
		ps.close();
		con.close();
		
		return count;
		
	}
	
	
}
