package com.example.demoKafka;

import java.util.Map;

import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

/**
 * @author leonardo
 *
 */
@Service
public class MetricsReporter {

	private static final String LINE_BREAK = "\n";
	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	/**
	 * 
	 * Constrói uma {@link String} com as métricas por clienteId.
	 * 
	 * @return
	 */
	public String getMetrics() {
		
		StringBuilder sb = new StringBuilder();
		
		for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
				.getListenerContainers()) {
			
			Map<String, Map<MetricName, ? extends Metric>> metrics = messageListenerContainer.metrics();

			metrics.forEach((clientid, metricMap) -> {
				
				sb.append("------------------------For client id : " + clientid + LINE_BREAK);
				
				metricMap.forEach((metricName, metricValue) -> {
					
					sb.append("------------Metric name: " + metricName.name() + "-----------Metric value: "
							+ metricValue.metricValue() + LINE_BREAK);
					
				});
			});
			
		}
		
		String metrics = sb.toString();
		
		System.out.println(metrics);
		
		return metrics;
		
	}

}
