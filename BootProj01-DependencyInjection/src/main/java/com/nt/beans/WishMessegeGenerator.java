package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("wmg")
public class WishMessegeGenerator {
	
	public WishMessegeGenerator() {
		System.out.println("WishMessegeGenerator-0-param constructor");
	}
	
	@Autowired
	private Calendar calender;
	
	//b.method
	public String generateWishMessege(String user) {
		System.out.println("WishMessegeGenerator.generateWishMessege()");
		//get current hour of the day
		int hour=calender.get(Calendar.HOUR_OF_DAY);
		//generate wish messege
		if(hour<12)
			return "Good morning::"+user;
		else if(hour<16)
			return "Good afternoon::"+user;
		else if(hour<20)
			return "Good Evening::"+user;
		else
			return "Good Night::"+user;
	}

}
