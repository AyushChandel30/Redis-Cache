package com.db.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.db.config.AppConstants;

@Service
public class KafkaService {
	
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);

	@Autowired	//			key		value
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public Boolean updateLocation (String location) {
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME, location);
		this.logger.info("******************Message Produced*************************");
		return true;
	}

}
