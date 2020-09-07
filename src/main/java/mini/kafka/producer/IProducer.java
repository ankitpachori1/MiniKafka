package mini.kafka.producer;

import mini.kafka.exception.KafkaException;
import org.json.JSONObject;

public interface IProducer {
    void produce(String topicName, JSONObject object) throws KafkaException;
    void registerTopic(String topicName) throws KafkaException;
}
