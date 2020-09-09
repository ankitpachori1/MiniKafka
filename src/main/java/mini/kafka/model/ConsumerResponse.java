package mini.kafka.model;

import lombok.Data;

import java.util.Map;

@Data
public class ConsumerResponse extends GenericResponse{
    public Map<String, Object> message;
    public ConsumerResponse(Map<String, Object> jsonObject){
        this.message = jsonObject;
    }
    public ConsumerResponse(Integer errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
