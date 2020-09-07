package mini.kafka.exception;

import mini.kafka.enums.ExceptionDesc;

public class KafkaException extends Exception {

    public ExceptionDesc exceptionDesc;

    public KafkaException(ExceptionDesc exceptionDesc){
        super(exceptionDesc.name());
    }
}
