package mini.kafka.controller;

import mini.kafka.exception.KafkaException;
import mini.kafka.producer.Producer;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    Producer producer;

    @PostMapping("/produce/{topic}")
    public ResponseEntity produce(@PathVariable("topic") String topicName,
                                  @RequestBody String inputJson) {
        try{
            JSONObject object = new JSONObject(inputJson);
            producer.produce(topicName, object);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        catch (KafkaException | JSONException e){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register/{topic}")
    public ResponseEntity registerTopic(@PathVariable("topic") String topicName) {
        try{
            producer.registerTopic(topicName);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        catch (KafkaException e){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

    }
}
