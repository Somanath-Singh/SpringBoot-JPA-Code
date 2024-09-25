//package com.nt.runner;
//
//
//
//import java.sql.CallableStatement;
//import java.sql.ResultSet;
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.dialect.OracleTypes;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import jakarta.persistence.EntityManager;
//
//
//
//@Component
//public class PL_SQLFunctionCallRunner implements CommandLineRunner {
//
//	
//	@Autowired
//	private EntityManager manager;
//	
//	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		//unwrap session object from EntityManager object
//		Session sec=manager.unwrap(Session.class);
//		//work  with returningWork<T> callback based method
//		Object result= sec.doReturningWork(con->{
//			//write CallbackStatement based logic to call PL/SQL function
//			CallableStatement cs=con.prepareCall("{?=call FX_GET_MOVIES_BY_RATINGS(?,?,?)}");
//			//register return ,out params with jdbc type
//			cs.registerOutParameter(1, OracleTypes.CURSOR);
//			cs.registerOutParameter(4, Types.INTEGER);
//			//set value to In parameters
//			cs.setFloat(2, 4.0f);
//			cs.setFloat(3, 5.0f);
//			
//			//call pl/sql function
//			cs.execute();
//			//gather results from output parameters
//			ResultSet rs=(ResultSet)cs.getObject(1);//return value
//			List<Object[]> list =new ArrayList();
//			while(rs.next()) {
//				Object record[]=new Object[3];
//				record[0]=rs.getString(1);
//				record[1]=rs.getString(2);
//				record[2]=rs.getString(3);
//				list.add(record);
//			}//while
//			Object  data[]=new Object[2];
//			data[0]=list;
//			data[1]=cs.getInt(4);//out param cnt value
//			
//			return data;
//			
//		});
//		//process the result[]
//		System.out.println("movies in ratings range are :");
//		
//		List<Object[]> ratingList=(List<Object[]>)results[0];
//		ratingList.forEach(md->{
//			for(Object val:md)
//				System.out.print(val+"   ");
//		System.out.println();
//		});
//		
//		//get count of records
//		int count=(int)results[1];
//		System.out.println("record count::"+count);
//		
//	}
//
//}

package com.nt.runner;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;

@Component("runner")
public class PL_SQLFunctionCallRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		//unWrap session object from EntityManager object
		Session ses=manager.unwrap(Session.class);
		//work with returningWork<T> callback based Callback Method
		Object results[]=ses.doReturningWork(con->{
			//write CallableStatement based logic to call PL/SQL function
			CallableStatement cs=con.prepareCall("{?= call FX_GET_MOVIES_BY_RATINGS(?,?,?)}");
			//register return, out param with JDBC types
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.registerOutParameter(4, Types.INTEGER);
			//set values to in param
			cs.setFloat(2, 6.4f);
			cs.setFloat(3, 8.6f);
			//call PL/SQL function
			cs.execute();
			//gather the result from Output Parameter
			ResultSet rs=(ResultSet)cs.getObject(1);
			List<Object[]> list=new ArrayList<>();
			while(rs.next()) {
				Object record[]=new Object[3];
						record[0]=rs.getString(1);
						record[1]=rs.getString(2);
						record[2]=rs.getString(3);
						list.add(record);
						}//while
			Object data[]=new Object[2];
			data[0]=list;
			data[1]=cs.getInt(4); 
			
	 		return data;
		});
		//process the result[]
		System.out.println("Movies in Rating Range::");
		@SuppressWarnings("unchecked")
		List<Object[]> ratingList=(List<Object[]>) results[0];
		ratingList.forEach(md->{
			for(Object var:md)
				System.out.print(var+" ");
			System.out.println();
		});
		//get Count of records
		int count=(int)results[1];
		System.out.println("Records Count::"+count);
	}
	

}
