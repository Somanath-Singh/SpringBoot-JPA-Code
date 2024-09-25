package com.nt.test;

import java.sql.Date;
import java.util.ArrayList;

import com.nt.comp.Employee;
import com.nt.comp.Person;
import com.nt.comp.Student;

public class App 
{
	
	
	public <T> T showDetails(Class<T> clazz)throws Exception {
		
		return (T)clazz.getDeclaredConstructor(new Class[] {}).newInstance();
		
	}
	
public <T extends Person> T showDetails1(Class<T> clazz)throws Exception {
		
		return (T)clazz.getDeclaredConstructor(new Class[] {}).newInstance();
		
	}
	
	
    public static void main( String[] args )throws Exception
    {

    	App app=new App();
    	Student st=app.showDetails(Student.class);
    	System.out.println(st);
    	System.out.println("------------------------------------------");
    	Employee emp=app.showDetails(Employee.class);
    	System.out.println(emp);
    	System.out.println("------------------------------------------");
    	ArrayList list=app.showDetails(ArrayList.class);
    	System.out.println(list);
    	System.out.println("------------------------------------------");
    	Date date=app.showDetails(Date.class);
    	System.out.println(date);
    	System.out.println("------------------------------------------");
    	
    	System.out.println("======================================================");
    	
    	
    	App app1=new App();
    	Student st1=app.showDetails1(Student.class);
    	System.out.println(st1);
    	System.out.println("------------------------------------------");
    	Employee emp1=app.showDetails1(Employee.class);
    	System.out.println(emp1);
    	System.out.println("------------------------------------------");
    	//error
    	//ArrayList list1=app.showDetails1(ArrayList.class);
    	//System.out.println(list1);
    	System.out.println("------------------------------------------");
    	//error
    	//Date date1=app.showDetails1(Date.class);
    	//System.out.println(date1);
    	System.out.println("------------------------------------------");
    }
}
