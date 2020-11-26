package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Consumer with default load balancing Ribbon (round Robin).
 * Use Consul.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for Consul
@EnableDiscoveryClient
public class ConsumerRibbonConsul83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonConsul83.class, args);
    }
}
