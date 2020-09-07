package mini.kafka.producer;

import mini.kafka.exception.KafkaException;
import mini.kafka.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer implements IProducer{

    @Autowired
    private MessageRepo repo;

    @Override
    public void produce(String topicName, JSONObject object) throws KafkaException {
        repo.saveMessage(topicName, object);
    }

    @Override
    public void registerTopic(String topicName) throws KafkaException{
        repo.createTopic(topicName);
    }
}
