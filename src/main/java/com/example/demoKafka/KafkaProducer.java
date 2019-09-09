package com.example.demoKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author leonardo
 *
 */
@Component
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, Person> kafkaTemplate;

	public void sendMessage(Person person) {

		ListenableFuture<SendResult<String, Person>> future = kafkaTemplate.send("maca3", person);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Person>>() {

			@Override
			public void onSuccess(SendResult<String, Person> result) {
				System.out.println(
						"Sent message=[" + person + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Unable to send message=[" + person + "] due to : " + ex.getMessage());
			}
		});
	}

}
