package com.rabbitmq.producer.model;


import com.util.common.UserPayload;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Getter
@Setter
@Document
public class User {

    private String id;
    private String firstName;
    private String lastName;

    public static User create(final UserPayload userPayload){
        final User user = new User();

        user.id = UUID.randomUUID().toString();
        user.firstName = userPayload.getFirstName();
        user.lastName = userPayload.getLastName();

        return user;
    }
}
