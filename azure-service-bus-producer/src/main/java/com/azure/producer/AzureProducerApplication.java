package com.azure.producer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class AzureProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AzureProducerApplication.class, args);
    }
}
