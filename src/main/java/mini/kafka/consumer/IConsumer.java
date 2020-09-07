package mini.kafka.consumer;

import mini.kafka.exception.KafkaException;
import mini.kafka.model.ConsumerResponse;

public interface IConsumer {
    public ConsumerResponse consume(String topic, Integer offset) throws KafkaException;
}
