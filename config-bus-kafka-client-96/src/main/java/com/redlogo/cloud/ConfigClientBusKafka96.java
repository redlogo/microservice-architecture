package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Cloud Config client side.
 * Working with Spring Cloud Bus RabbitMQ.
 * With Spring Cloud Bus Kafka, refresh all client by: curl -X POST "http://localhost:7008/actuator/bus-refresh"
 * Or with target: curl -X POST "http://localhost:7007/actuator/bus-refresh/config-client-bus-kafka-service:90"
 * Default Kafka Topic is: springCloudBus
 *
 * Config server side must be on, then turn on Config client side.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientBusKafka96 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBusKafka96.class, args);
    }
}