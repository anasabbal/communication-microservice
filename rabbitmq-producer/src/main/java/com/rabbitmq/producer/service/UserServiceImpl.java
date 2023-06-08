package com.rabbitmq.producer.service;



import com.rabbitmq.producer.model.User;
import com.rabbitmq.producer.repository.UserRepository;
import com.util.common.DataEvent;
import com.util.common.EventType;
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
    private final UserRepository userRepository;
    private static final String PRODUCER_BINDING_NAME = "userProducer-out-0";


    @Override
    public Mono<UserPayload> createUser(UserPayload userPayload) {
        DataEvent<String, UserPayload> event = new DataEvent<>(EventType.CREATE, null, userPayload);
        boolean sent = streamBridge.send(PRODUCER_BINDING_NAME, event);
        userRepository.save(User.create(userPayload));
        return sent ? Mono.just(userPayload).log("User created successfully !") : Mono.error(new BadRequestException("Error streaming data"));
    }
}
