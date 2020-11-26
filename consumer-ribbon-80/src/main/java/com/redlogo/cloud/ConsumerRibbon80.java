package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Consumer using default Netflix Ribbon (round Robin).
 * Use Netflix Eureka.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for eureka
@EnableEurekaClient
public class ConsumerRibbon80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbon80.class, args);
    }
}
