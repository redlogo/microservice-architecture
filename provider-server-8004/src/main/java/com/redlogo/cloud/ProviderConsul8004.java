package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * A provider (payment) microservice
 * Use Consul
 * GUI - http://localhost:8500
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for Consul
@EnableDiscoveryClient
public class ProviderConsul8004 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderConsul8004.class, args);
    }
}
