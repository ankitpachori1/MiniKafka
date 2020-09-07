package mini.kafka.model;

import lombok.Data;
import org.json.JSONObject;

import java.time.LocalDateTime;

@Data
public final class Message {

    final JSONObject object;

    final LocalDateTime time;

    public Message(JSONObject object){
        this.object = object;
        time = LocalDateTime.now();
    }
}
