package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Tourist;
import com.nt.repository.ITuristRepo;

@Service("touristservice")
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITuristRepo touristrepo;
	
	
	@Override
	public String registerTourist(Tourist tourist) {

		return "Document is saved with id value::"+touristrepo.insert(tourist).getId();

	}


	@Override
	public List<Tourist> fetchAllTourists() {

		return touristrepo.findAll();
		
	}
	@Override
	public String saveTouristGroup(List<Tourist> tourists) {

		int count=touristrepo.saveAll(tourists).size();
		return count+" no of tourists are saved";
		
	}

}
