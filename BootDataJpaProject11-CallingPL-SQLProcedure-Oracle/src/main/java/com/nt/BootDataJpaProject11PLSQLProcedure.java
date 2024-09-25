package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@SpringBootApplication
public class BootDataJpaProject11PLSQLProcedure {

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(BootDataJpaProject11PLSQLProcedure.class, args);
	
	EntityManager manager=ctx.getBean(EntityManager.class);
	

	//create StoredprocedureQuery object representing the given PL/SQL procedure
			StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_MOVIES_BY_YEAR_RANGE",Movie.class);
			//register parameters of PL/Sql procedure with java types
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(3, Movie.class, ParameterMode.REF_CURSOR);
			//set values to IN params
			query.setParameter(1, "2021");
			query.setParameter(2, "2022");
			
			//call PL/SQL Procedure and get the results
			List<Movie> list=query.getResultList();
			list.forEach(System.out::println);
			
	}  

	}   
	
	
