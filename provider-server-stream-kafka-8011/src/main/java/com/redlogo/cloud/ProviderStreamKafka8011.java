package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Use Spring Cloud Stream.
 * Send message by API defined in controller layer.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
public class ProviderStreamKafka8011 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderStreamKafka8011.class, args);
    }
}
