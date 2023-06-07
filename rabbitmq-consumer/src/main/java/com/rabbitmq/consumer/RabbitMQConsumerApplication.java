package com.rabbitmq.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.util.common.DataEvent;
import com.util.common.JSONUtil;
import com.util.common.UserPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;


@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class RabbitMQConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumerApplication.class, args);
    }

    @Bean
    public Consumer<DataEvent<String, UserPayload>> userConsumer() {
        return event -> {
            log.info("Consuming message event created at {}", event.getEventCreatedAt());

            switch (event.getEventType()) {
                case CREATE  -> {
                    UserPayload userPayload = event.getData();
                    try {
                        log.info("Creating user of the following {}", JSONUtil.toJSON(userPayload));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + event.getEventType());
            };
        };
    }
}
