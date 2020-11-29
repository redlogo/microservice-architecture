package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Consumer of Spring Cloud Stream, with Topic group set.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
public class ConsumerStreamKafka97 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerStreamKafka97.class, args);
    }
}
