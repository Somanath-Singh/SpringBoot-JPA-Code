package com.nt.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("petrol")
//@Primary
public final class PetrolEngine implements Engine {
	
	public PetrolEngine() {
		System.out.println("PetrolEngine.PetrolEngine()(::0-param constructor)");
	}

	@Override
	public void start() {
		
		System.out.println("Petrolengine.start()");

	}

	@Override
	public void stop() {

		System.out.println("Petrolengine.stop()");

	}

}
