package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * A provider (payment) microservice
 * Use Zookeeper
 * zkCli: get /services/provider-payment-service-zookeeper/provider-payment-8003
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for Zookeeper
@EnableDiscoveryClient
public class ProviderZookeeper8003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderZookeeper8003.class, args);
    }
}
