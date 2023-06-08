package com.azure.servicehub;


import com.azure.servicehub.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.JmsListener;


@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class AzureServiceHubApplication {

    private static final String TOPIC_NAME = "values-topic";

    private static final String SUBSCRIPTION_NAME = "customersub";

    public static void main(String[] args) {
        SpringApplication.run(AzureServiceHubApplication.class, args);
    }

    @JmsListener(destination = TOPIC_NAME, containerFactory = "jmsListenerContainerFactory", subscription = SUBSCRIPTION_NAME)
    public void receiveMessage(User user) {
        log.info("Received message from topic: {}", user.getName());
    }
}
