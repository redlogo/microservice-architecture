package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A provider (payment) microservice.
 * Use Netflix Eureka.
 * Use Spring Data JPA.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for eureka
@EnableEurekaClient
public class ProviderSpringDataJPA8008 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderSpringDataJPA8008.class, args);
    }
}
