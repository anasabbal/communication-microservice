package com.util.common;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface JSONUtil {
    ObjectMapper objectMapper = new ObjectMapper();

    static String toJSON(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
