package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Cloud Gateway.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway7005 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway7005.class, args);
    }
}
