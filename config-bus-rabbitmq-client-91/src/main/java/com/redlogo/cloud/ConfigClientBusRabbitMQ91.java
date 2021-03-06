package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Cloud Config client side.
 * Working with Spring Cloud Bus RabbitMQ.
 * With Spring Cloud Bus RabbitMQ, refresh all client by: curl -X POST "http://localhost:7007/actuator/bus-refresh"
 * Or with target: curl -X POST "http://localhost:7007/actuator/bus-refresh/config-client-bus-rabbitmq-service:90"
 *
 * Config server side must be on, then turn on Config client side.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientBusRabbitMQ91 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBusRabbitMQ91.class, args);
    }
}