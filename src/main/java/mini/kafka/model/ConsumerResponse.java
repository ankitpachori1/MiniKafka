package mini.kafka.model;

import lombok.Data;
import org.json.JSONObject;

@Data
public class ConsumerResponse extends GenericResponse{
    public JSONObject jsonObject;
    public ConsumerResponse(JSONObject jsonObject, Integer errCode, String errMsg){
        this.jsonObject = jsonObject;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
