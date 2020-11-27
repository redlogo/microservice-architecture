package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A service discovery microservice.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for eureka
@EnableEurekaClient
public class Discovery9001 {
    public static void main(String[] args) {
        SpringApplication.run(Discovery9001.class, args);
    }
}
