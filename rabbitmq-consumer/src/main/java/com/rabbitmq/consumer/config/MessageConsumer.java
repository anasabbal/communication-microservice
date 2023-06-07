package com.rabbitmq.consumer.config;


import com.util.common.DataEvent;
import com.util.common.UserPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Slf4j
@Component
public class MessageConsumer {

    @Bean
    public Consumer<DataEvent<String, UserPayload>> userConsumer() {
        return event -> {
            log.info("Consuming message event created at {}", event.getEventCreatedAt());

             switch (event.getEventType()) {
                case CREATE  -> {
                    UserPayload userPayload = event.getData();
                    log.info("Creating user of the following {}", userPayload);
                }
                default -> throw new IllegalStateException("Unexpected value: " + event.getEventType());
            };
        };
    }
}
