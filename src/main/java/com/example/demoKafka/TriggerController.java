package com.example.demoKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Controller para adicionar e pegar métricas.
 * 
 * @author leonardo
 *
 */
@RestController("/")
public class TriggerController {
	
	@Autowired
	Sender sender;
	
	@Autowired
	MetricsReporter metrics;

	/**
	 * 
	 * Endpoint simples para adicionar um cara.
	 * 
	 * @param person
	 * @return
	 */
	@PostMapping("person")
	public Person add(Person person) {
		
		sender.sendMessage(person);
		
		return person;
	}
	
	/**
	 * 
	 * Endpoint para pegar métricas.
	 * 
	 * @return
	 */
	@GetMapping("personlag")
	public String getMetrics () {
		return metrics.getMetrics();
	}
	
}
