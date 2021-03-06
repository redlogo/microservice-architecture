package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Consumer using default Netflix Ribbon (round Robin).
 * Use Feign (on top of Eureka).
 * Use Hystrix.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// For Feign, which is on top of Eureka
@EnableFeignClients
// For Hystrix
@EnableHystrix
public class ConsumerFeignHystrix86 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrix86.class, args);
    }
}
