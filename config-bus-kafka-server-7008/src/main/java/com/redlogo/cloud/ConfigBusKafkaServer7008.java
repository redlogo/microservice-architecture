package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Cloud Config server side.
 * Accessed by http://localhost:7007/master/config-test.yml format: /{label}/{application}-{profile}.yml
 * With Spring Cloud Bus Kafka, refresh all client by: curl -X POST "http://localhost:7007/actuator/bus-refresh"
 * Or with target: curl -X POST "http://localhost:7007/actuator/bus-refresh/config-client-bus-kafka-service:90"
 * Default Kafka Topic is: springCloudBus
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// enable Spring Cloud Config server
@EnableConfigServer
public class ConfigBusKafkaServer7008 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigBusKafkaServer7008.class, args);
    }
}