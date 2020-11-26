package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A provider (payment) microservice.
 * Use Netflix Eureka.
 * Use Druid database connection pool instead of Hikari (default).
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for eureka
@EnableEurekaClient
public class ProviderDruidPool8006 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderDruidPool8006.class, args);
    }
}
