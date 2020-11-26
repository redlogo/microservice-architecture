package com.redlogo.cloud;

import com.redlogo.feign.FeignCustomizedStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Consumer using default Netflix Ribbon (round Robin).
 * Use Feign (on top of Eureka).
 * Use customized load balancing strategy.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// For Feign, which is on top of Eureka
@EnableFeignClients()
// Use customized Ribbon load balancing strategy, must be capitalized
@RibbonClient(name = "PROVIDER-PAYMENT-SERVICE", configuration = FeignCustomizedStrategy.class)
public class ConsumerFeignStrategy85 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignStrategy85.class, args);
    }
}
