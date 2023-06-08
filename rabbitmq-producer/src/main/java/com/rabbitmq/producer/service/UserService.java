package com.rabbitmq.producer.service;


import com.util.common.UserPayload;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserPayload> createUser(UserPayload userPayload);
}
