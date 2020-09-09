package mini.kafka.exception;

import mini.kafka.enums.ExceptionDesc;

public class KafkaException extends Exception {

    public KafkaException(ExceptionDesc exceptionDesc){
        super(exceptionDesc.name());
    }
}
