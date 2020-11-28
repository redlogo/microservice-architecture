package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Cloud Config.
 * Accessed by http://config-7006.com:7006/master/config-test.yml format: /{label}/{application}-{profile}.yml
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// enable Spring Cloud Config server
@EnableConfigServer
public class Config7006 {
    public static void main(String[] args) {
        SpringApplication.run(Config7006.class, args);
    }
}