## demoKafka

Projeto simples com producer/consumer que gera algumas mensagens num tópico.

# Rodando o Kafka

```sh
docker-compose up -d
```

# Create topic

```sh
docker exec -it meu_kafka_kafka_1 kafka-topics.sh --create --zookeeper zookeeper:2181 -replication-factor 1 --partitions 1 --topic pastel
```

# Criando consumer/producer para testes:

- Producer
 
```sh
docker exec -it meu_kafka_kafka_1 kafka-console-producer.sh --broker-list localhost:9092 --topic pastel
```

- Consumer 

```sh
docker exec -it meu_kafka_kafka_1 kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic pastel --from-beginning
```
# Como usar

http://localhost:8080/swagger-ui.html
