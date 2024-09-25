package com.nt.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;



@Component
//@Order(-1)
public class BCTestRunner implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCTestRunner.run()");
		
		System.out.println("Runner to test ..."+Arrays.toString(args));

	}


	//ordered interface getting highest priority value
	@Override
	public int getOrder() {
		return -1;
	}

}
