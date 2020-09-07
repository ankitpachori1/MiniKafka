package mini.kafka.consumer;

import mini.kafka.exception.KafkaException;
import mini.kafka.model.ConsumerResponse;
import mini.kafka.repo.MessageRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Consumer implements IConsumer {

    @Autowired
    MessageRepo repo;

    @Override
    public ConsumerResponse consume(String topic, Integer offset) throws KafkaException {
        JSONObject jsonObject = repo.consume(topic, offset);
        return new ConsumerResponse(jsonObject, null, null);
    }
}
