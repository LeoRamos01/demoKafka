package com.example.demoKafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author leonardo
 *
 */
@Component
public class KafkaConsumer {

	@KafkaListener(topics = "pastel", groupId = "grupo1")
	public void listen(String message) {
		System.out.println("Received Message: " + message);
	}

}
