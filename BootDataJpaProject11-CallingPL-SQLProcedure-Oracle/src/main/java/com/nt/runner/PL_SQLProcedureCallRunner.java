package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;


//@Component
public class PL_SQLProcedureCallRunner implements CommandLineRunner {

	
	@Autowired
	private EntityManager manager;
	
	
	@Override
	public void run(String... args) throws Exception {

		
	}

}
