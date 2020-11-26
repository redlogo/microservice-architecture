package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * An Eureka server
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// signature: enable Eureka server, dashboard @ http://localhost:7002
@EnableEurekaServer
public class Eureka7002 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002.class, args);
    }
}
