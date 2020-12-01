package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
	
	@Autowired
	private ResultRepository resultRepository;
	
	public void saveResult(Result result) {
		resultRepository.save(result);
	}
	
}
