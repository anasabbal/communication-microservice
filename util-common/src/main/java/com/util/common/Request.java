package com.util.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request implements Serializable {
    private static final long serialVersionUID = -295422713255886286L;
    private String firstName;
    private String lastName;
}
