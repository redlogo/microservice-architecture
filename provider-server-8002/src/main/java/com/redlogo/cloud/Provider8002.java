package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A provider (payment) microservice.
 * Use Netflix Eureka.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for eureka
@EnableEurekaClient
public class Provider8002 {
    public static void main(String[] args) {
        SpringApplication.run(Provider8002.class, args);
    }
}
