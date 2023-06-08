package com.rabbitmq.consumer.model;

import com.util.common.UserPayload;

public class User {

    private String firstName;
    private String lastName;

    public static User createPayload(final UserPayload userPayload){
        final User user = new User();

        user.firstName = userPayload.getFirstName();
        user.lastName = userPayload.getLastName();

        return user;
    }
}
