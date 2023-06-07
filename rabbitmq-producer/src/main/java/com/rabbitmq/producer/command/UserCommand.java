package com.rabbitmq.producer.command;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCommand {
    private String firstName;
    private String lastName;
}
