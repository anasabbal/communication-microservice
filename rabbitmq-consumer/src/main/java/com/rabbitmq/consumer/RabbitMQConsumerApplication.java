package com.rabbitmq.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;





@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class RabbitMQConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumerApplication.class, args);
    }
}
