package com.redlogo.cloud;

import com.redlogo.ribbon.RibbonCustomizedStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Consumer using customized Netflix Ribbon (defined in RibbonCustomizedStrategy).
 * Use Netflix Eureka.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// For Eureka
@EnableEurekaClient
// Use customized Ribbon load balancing strategy, must be capitalized
@RibbonClient(name = "PROVIDER-PAYMENT-SERVICE", configuration = RibbonCustomizedStrategy.class)
public class ConsumerRibbonStrategy81 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonStrategy81.class, args);
    }
}
