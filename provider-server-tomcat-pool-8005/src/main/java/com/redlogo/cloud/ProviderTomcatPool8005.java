package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A provider (payment) microservice.
 * Use Netflix Eureka.
 * Use Tomcat database connection pool instead of Hikari (default).
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for eureka
@EnableEurekaClient
public class ProviderTomcatPool8005 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderTomcatPool8005.class, args);
    }
}
