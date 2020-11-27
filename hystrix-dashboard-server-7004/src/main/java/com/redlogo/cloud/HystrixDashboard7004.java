package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix Dashboard.
 * Enable http://localhost:7004/hystrix
 * Use http://localhost:8007/hystrix.stream in dashboard.
 * Services like 8007 needs actuator.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard7004 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard7004.class, args);
    }
}
