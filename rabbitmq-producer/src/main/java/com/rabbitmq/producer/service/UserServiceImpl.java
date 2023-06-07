package com.rabbitmq.producer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.rabbitmq.producer.command.UserCommand;
import com.rabbitmq.producer.model.User;
import com.util.common.DataEvent;
import com.util.common.EventType;
import com.util.common.JSONUtil;
import com.util.common.UserPayload;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final StreamBridge streamBridge;
    private static final String PRODUCER_BINDING_NAME = "userProducer-out-0";


    @Override
    public User create(UserCommand command) throws JsonProcessingException {
        log.info("[+] Begin creating User with payload {}", JSONUtil.toJSON(command));
        final User user = User.create(command);
        streamBridge.send("topic-value", command);
        if(streamBridge.send("topic-value", command))
            return null;
        else
            return null;
    }

    @Override
    public Mono<UserPayload> createUser(UserPayload userPayload) {
        DataEvent<String, UserPayload> event = new DataEvent<>(EventType.CREATE, null, userPayload);
        boolean sent = streamBridge.send(PRODUCER_BINDING_NAME, event);

        return sent ? Mono.just(userPayload).log("USER PAYLOAD CREATED GOOD!") : Mono.error(new BadRequestException("Error streaming data"));
    }
}
