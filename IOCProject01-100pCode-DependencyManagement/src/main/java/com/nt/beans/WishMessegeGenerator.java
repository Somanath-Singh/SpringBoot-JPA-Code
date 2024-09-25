package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg") //spring bean cfg having "wmg" as the bean id
public class WishMessegeGenerator {
	
	//HAS_A property
	@Autowired   //annotation making the HAS-A property for dependency injection/management
	private LocalDateTime ldt;//by default holds null after injection/writing this null will be reolaced
														//with Dependent LocalDateTime class object
	
	//to check wheather the object is created or not constructor created
	public WishMessegeGenerator() {
		System.out.println("WishMessegeGenerator.WishMessegeGenerator()::0param constructor");
	}
	
	
	//b method
	public String generateWishMessege(String user) {
		//get current hour
		int hour=ldt.getHour();
		//write b.logic
		if(hour<12)
			return "Good Morning "+user;
		else if(hour<16)
			return "Good Afternoon"+user;
		else if(hour<20)
			return "Good Evening "+user;
		else 
			return "Good Night "+user;
	}
	

}
