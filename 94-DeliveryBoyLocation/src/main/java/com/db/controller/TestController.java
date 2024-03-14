package com.db.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.service.KafkaService;

@RestController
@RequestMapping ("/location")
public class TestController {
	
	@Autowired
	private KafkaService kafkaService;

	@PostMapping ("/update")
	public ResponseEntity<?> updateLocation() {
		this.kafkaService.updateLocation("{" + Math.round(Math.random()*100) + " , " 
		+ Math.round(Math.random()*100) + "}");
		return new ResponseEntity<> (Map.of("message", //key
											"Location updated") //value
									,HttpStatus.OK);
	} 
}
