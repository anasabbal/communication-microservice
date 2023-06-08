package com.azure.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.util.common.JSONUtil;
import com.util.common.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.JmsListener;



@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class AzureConsumerApplication {

    private static final String TOPIC_NAME = "values-topic";

    private static final String SUBSCRIPTION_NAME = "customersub";

    public static void main(String[] args) {
        SpringApplication.run(AzureConsumerApplication.class, args);
    }

    @JmsListener(destination = TOPIC_NAME, containerFactory = "jmsListenerContainerFactory", subscription = SUBSCRIPTION_NAME)
    public void receiveMessage(Request request) throws JsonProcessingException {
        log.info("Received message from topic: {}", JSONUtil.toJSON(request));
    }
}
