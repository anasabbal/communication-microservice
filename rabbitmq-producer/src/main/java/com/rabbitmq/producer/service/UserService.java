package com.rabbitmq.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rabbitmq.producer.command.UserCommand;
import com.rabbitmq.producer.model.User;
import com.util.common.UserPayload;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserPayload> createUser(UserPayload userPayload);
    User create(final UserCommand command) throws JsonProcessingException;
}
