package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
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