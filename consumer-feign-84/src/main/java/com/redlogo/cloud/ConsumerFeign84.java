package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Consumer using default Netflix Ribbon (round Robin).
 * Use Feign (on top of Eureka).
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// For Feign, which is on top of Eureka
@EnableFeignClients
public class ConsumerFeign84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign84.class, args);
    }
}
