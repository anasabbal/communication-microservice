package com.rabbitmq.producer.controller;


import com.rabbitmq.producer.service.UserService;
import com.util.common.UserPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/user")
    public Mono<UserPayload> createUser(@RequestBody UserPayload user) {
        return userService.createUser(user);
    }
}
