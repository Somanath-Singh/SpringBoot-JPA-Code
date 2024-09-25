package com.nt;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootProject11RunnersLambdaApplication {
	
	@Bean
	public CommandLineRunner createCLRunner() {
		
		//Lamnda impl for functional interface
//		CommandLineRunner clr=(String ...args )->{
//			System.out.println("From command line runners"+Arrays.toString(args));
//		};
//		return clr;
		
//		CommandLineRunner clr=(args)->System.out.println("From command line runners"+Arrays.toString(args));
//		return clr;
		
//		CommandLineRunner clr=args->System.out.println("From command line runners"+Arrays.toString(args));
//		return clr;
		
		//Lamnda impl for functional interface for foreach  //enhanced for loop
		/*CommandLineRunner clr=args->{
			System.out.println("BootProject11RunnersLambdaApplication.createCLRunner()");
			
			for(String arg:args) {
				System.out.println(arg);
			}
		};
		return clr;*/
		
		//Lamnda impl for functional interface + stream api +static method reference
		CommandLineRunner clr=args->{
			System.out.println("Command line runners");
			Stream.of(args).forEach(System.out::println);;
		};
		
		return clr;
		
	}
	
	@Bean
	public ApplicationRunner createApplicationRunner() {
		
		return args->{
			
			System.out.println("Application Runners");
			
			System.out.println("non option values:"+args.getNonOptionArgs());
			System.out.println("option arg names and values");
			Set<String> optionargs=args.getOptionNames();
			
			optionargs.forEach(org->{
				
				System.out.println(org);
				System.out.println(args.getOptionValues(org));
				
			});
			
		};
		
	}

	public static void main(String[] args) {
		SpringApplication.run(BootProject11RunnersLambdaApplication.class, args);
	}

}
