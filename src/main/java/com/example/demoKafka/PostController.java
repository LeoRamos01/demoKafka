package com.example.demoKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Endpoint simples para adicionar um cara.
 * 
 * @author leonardo
 *
 */
@RestController("/")
public class PostController {
	
	@Autowired
	KafkaProducer producer;

	@PostMapping("person")
	public Person add(Person person) {
		
		producer.sendMessage(person);
		
		return person;
	}
	
}
