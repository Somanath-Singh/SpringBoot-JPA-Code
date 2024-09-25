package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("diesel")
public final class DieselEngine implements Engine {
	
	public DieselEngine() {
		System.out.println("DieselEngine.DieselEngine(::0-param constructor)");
	}

	@Override
	public void start() {
		System.out.println("DieselEngine.start()");

	}

	@Override
	public void stop() {

		System.out.println("DieselEngine.stop()");

	}

}
