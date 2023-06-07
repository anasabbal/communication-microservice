package com.rabbitmq.producer.model;


import com.rabbitmq.producer.command.UserCommand;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {

    private String id;
    private String firstName;
    private String lastName;

    public static User create(final UserCommand userCommand){
        final User user = new User();

        user.firstName = userCommand.getFirstName();
        user.lastName = userCommand.getLastName();

        return user;
    }
}
