package com.redlogo.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author redlogo
 * @version 0.1
 */
@Component
// controller layer define message consumer / sink
// this is a message sink, import org.springframework.cloud.stream.messaging.Sink
// automatically pull message from MQ and execute logics
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("Consumer at serverPort: " + serverPort + " received message: " + message.getPayload());
    }
}
