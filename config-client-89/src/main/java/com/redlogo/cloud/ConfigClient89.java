package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Cloud Config client side.
 * Can accept dynamic post changes: curl -X POST "http://localhost:89/actuator/refresh" which is done by DevOps.
 * For better notification methodology, use Spring Cloud Bus with Config.
 *
 * Config server side must be on, then turn on Config client side.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient89 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient89.class, args);
    }
}