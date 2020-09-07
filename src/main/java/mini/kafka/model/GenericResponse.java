package mini.kafka.model;

import lombok.Data;

@Data
public class GenericResponse {
    public Integer errCode;
    public String errMsg;
}
