package mini.kafka.consumer;

import com.google.gson.Gson;
import mini.kafka.exception.KafkaException;
import mini.kafka.model.ConsumerResponse;
import mini.kafka.repo.MessageRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Consumer implements IConsumer {

    @Autowired
    MessageRepo repo;

    @Override
    public ConsumerResponse consume(String topic, Integer offset) throws KafkaException {
        JSONObject jsonObject = repo.consume(topic, offset);
        Map<String, Object> json =  new Gson().fromJson(jsonObject.toString(), HashMap.class);
        return new ConsumerResponse(json);
    }
}
