package com.util.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPayload {
    private String id;
    private String username;
    private String email;
    private String name;
    private String serviceAddress;

    public UserPayload(String username, String email, String name) {
        this.username = username;
        this.email = email;
        this.name = name;
    }
}
