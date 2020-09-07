package mini.kafka.controller;

import mini.kafka.consumer.Consumer;
import mini.kafka.exception.KafkaException;
import mini.kafka.model.ConsumerResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    Consumer consumer;

    @GetMapping("/consume/{topic}/{offset}")
    public ResponseEntity<ConsumerResponse> consume(@PathVariable("topic") String topic, @PathVariable("offset") Integer offset){
        ConsumerResponse response;
        try{
            response = consumer.consume(topic,offset);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (KafkaException e){
            response = new ConsumerResponse(null, 400, e.exceptionDesc.name());
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

}
