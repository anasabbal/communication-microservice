package com.rabbitmq.producer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RabbitMQProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProducerApplication.class, args);
    }
}