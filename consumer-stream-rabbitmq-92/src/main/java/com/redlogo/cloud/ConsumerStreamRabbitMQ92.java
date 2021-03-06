package com.redlogo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Consumer of Spring Cloud Stream, with Exchange group set.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
public class ConsumerStreamRabbitMQ92 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerStreamRabbitMQ92.class, args);
    }
}
