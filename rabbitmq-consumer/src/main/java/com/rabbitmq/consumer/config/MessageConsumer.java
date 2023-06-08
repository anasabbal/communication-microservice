package com.rabbitmq.consumer.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.rabbitmq.consumer.model.Profile;
import com.rabbitmq.consumer.repository.ProfileRepository;
import com.util.common.DataEvent;
import com.util.common.JSONUtil;
import com.util.common.UserPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {

    private final ProfileRepository profileRepository;
    @Bean
    public Consumer<DataEvent<String, UserPayload>> userConsumer() {
        return event -> {
            log.info("Consuming message event created at {}", event.getEventCreatedAt());

            switch (event.getEventType()) {
                case CREATE  -> {
                    final Profile profile = Profile.create(event.getData());
                    profileRepository.save(profile);
                    try {
                        log.info("Creating user of the following {}", JSONUtil.toJSON(event.getData()));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + event.getEventType());
            };
        };
    }
}
