package mini.kafka.repo;

import mini.kafka.enums.ExceptionDesc;
import mini.kafka.exception.KafkaException;
import mini.kafka.model.Message;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MessageRepo {

    Map<String, Map<Integer, Message>> data;

    @PostConstruct
    public void init(){
        data = new HashMap<>();
    }

    public void saveMessage(String topic, JSONObject object) throws KafkaException {
        if(!data.containsKey(topic)) {
            throw new KafkaException(ExceptionDesc.TOPIC_NOT_PRESENT);
        }
        Map<Integer, Message> m = data.get(topic);
        m.put(m.size()+1, new Message(object));
        data.put(topic, m);
    }

    public void createTopic(String topic) throws KafkaException {
        if(data.containsKey(topic)){
            throw new KafkaException(ExceptionDesc.TOPIC_ALREADY_EXISTS);
        }
        data.put(topic, new HashMap<>());
    }

}
