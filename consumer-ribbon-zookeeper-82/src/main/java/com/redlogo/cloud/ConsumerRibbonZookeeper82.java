package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Consumer with default load balancing Ribbon (round Robin).
 * Use Zookeeper.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for Zookeeper
@EnableDiscoveryClient
public class ConsumerRibbonZookeeper82 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonZookeeper82.class, args);
    }
}
