package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("vehicle")
//(rule no 3)
public final class Vehicle {
	
	@Autowired//for field level Dependency injection
	@Qualifier("engineType")
	private Engine engg;//HAS-A property (rule no 1)
			//HAS a property type is interface type (rule no 2)
			//All Dependent classes are implementing common interface startegyDp 
	
	
	public Vehicle() {
		System.out.println("Vehicle.Vehicle()");
	}
	
	
	//b.method
	public void journey(String startPlace,String destPlace) {
		engg.start();
		System.out.println("Vehicle ::journey started at ::"+startPlace);
		System.out.println("journey going on ....");
		engg.stop();
		System.out.println("Vehicle ::journey stoped at ::"+destPlace);
	}

}
