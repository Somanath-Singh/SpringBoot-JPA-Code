package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;


@Repository("mysqlEmpDao")
@Profile({"dev","test"})
public class MySqlEmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_EMP_DETAILS_BY_DESG="SELECT ENO,ENAME,DESG,SALARY FROM EMP_PROFILE WHERE DESG IN(?,?,?) ORDER BY DESG";
	
	@Autowired
	private DataSource ds;
	
	public MySqlEmployeeDaoImpl() {
		System.out.println("MySqlEmployeeDaoImpl::0-param constructor");
	}
	
	
	@Override
	public List<Employee> getEmployeebyDesg(String desg1, String desg2, String desg3) throws Exception {
		
		System.out.println("MySqlEmployeeDaoImpl.getEmployeebyDesg()"+ds.getClass());
		
		List<Employee> listemp=null;
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_EMP_DETAILS_BY_DESG);){
			//set the query param 
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			//execute the query
			try(ResultSet rs=ps.executeQuery();){
				//copy ResultSet object record to list collection as Employee Class object
				listemp=new ArrayList();
				
				while(rs.next()) {
					Employee emp=new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEmpname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSal(rs.getFloat(4));
					
					//add the object to list
					listemp.add(emp);
					
				}
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se;//exception rethrowing
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
		return listemp;
	}//method

}//class
