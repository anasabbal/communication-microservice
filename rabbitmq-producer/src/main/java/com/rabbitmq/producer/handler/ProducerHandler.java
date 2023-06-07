package com.rabbitmq.producer.handler;


import com.util.common.DataEvent;
import com.util.common.EventType;
import com.util.common.UserPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;


@Slf4j
@Component
public class ProducerHandler {

    @Value("${spring.cloud.stream.producer.produce}")
    private Boolean produce;

    @Bean
    public Supplier<DataEvent<String, UserPayload>> userProducer(){
        return () -> {
            if(produce)
                return getUserPayload();
            return null;
        };
    }
    private DataEvent<String, UserPayload> getUserPayload() {
        UserPayload user = new UserPayload("anas", "anas@gmail.com", "Anas");
        return new DataEvent<>(EventType.CREATE, null, user);
    }
}
