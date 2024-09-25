package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Tourist;
import com.nt.service.ITouristMgmtService;


@Component
public class MongoDbTestRunners implements CommandLineRunner {
	
	@Autowired
	private ITouristMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		//========================save document =========================

		/*try {
			//Tourist tourist=new Tourist(null,"Ramesh","USA",45.0f,"69853214TYG",9337169920L,true);
			Tourist tourist=new Tourist();
			tourist.setTouristname("Banty");
			tourist.setContactNo(99956569999L);
			String result=service.registerTourist(tourist);
			System.out.println(result);
		}
		catch(Exception se) {
			se.printStackTrace();
		}//try
		
		//===================findAll Document method==========================
		service.fetchAllTourists().forEach(System.out::println);
		*/
		
		//========saveAll(-)===============
		try {
			Tourist tourist1=new Tourist(null,"Charli","USA",45.0f,"69853214TYG",9337169920L,true);
			Tourist tourist2=new Tourist();
			tourist2.setTouristname("Banty");
			tourist2.setContactNo(99956569999L);
			Tourist tourist3=new Tourist(null,"Ramana","Canada",46.0f,"69853214TYG",9337169920L,true);
			List<Tourist> tourist=List.of(tourist1,tourist2,tourist3);
			String msg=service.saveTouristGroup(tourist);
			System.out.println(msg);
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
	}//run

}
