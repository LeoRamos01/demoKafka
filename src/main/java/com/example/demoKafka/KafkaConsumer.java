package com.example.demoKafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author leonardo
 *
 */
@Component
public class KafkaConsumer {

	@KafkaListener(topics = {"laranja" , "banana"}, groupId = "grupo1")
	public void listen(Person person) {
		System.out.println("Received person: " + person);
	}

}
