package com.rabbitmq.consumer.model;


import com.util.common.UserPayload;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Getter
@Setter
@Document
public class Profile {

    @Id
    private String id;
    private User user;

    public static  Profile create(final UserPayload userPayload){
        final Profile profile = new Profile();

        profile.id = UUID.randomUUID().toString();
        profile.user = User.createPayload(userPayload);

        return profile;
    }
}
