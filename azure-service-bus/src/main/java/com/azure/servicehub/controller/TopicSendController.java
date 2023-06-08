package com.azure.servicehub.controller;

import com.azure.servicehub.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@Slf4j
@RestController
public class TopicSendController {

    private static final String TOPIC_NAME = "values-topic";

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/topic")
    public String postMessage(@RequestParam String message) {
        log.info("Sending message");
        jmsTemplate.convertAndSend(TOPIC_NAME, new User(message));
        return message;
    }
}
