package com.azure.producer.controller;


import com.util.common.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@Slf4j
@RestController
@RequestMapping("/v1/producer")
@RequiredArgsConstructor
public class ProducerController {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final String TOPIC_NAME = "values-topic";

    @PostMapping
    public ResponseEntity<Boolean> sendRequest(@RequestBody Request request){
        log.info("Sending message");
        jmsTemplate.convertAndSend(TOPIC_NAME, request);
        return ResponseEntity.ok(true);
    }
}
