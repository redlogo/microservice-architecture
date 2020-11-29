package com.redlogo.cloud.service.impl;

import com.redlogo.cloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author redlogo
 * @version 0.1
 */
// service layer define message provider / source
// no need @Service, use @EnableBinding
// this is a message source, import org.springframework.cloud.stream.messaging.Source
@EnableBinding(Source.class)
@Slf4j
public class MessageProvider implements IMessageProvider {
    // message sending channel
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("Spring Cloud Stream (RabbitMQ) serial sent: " + serial);
        return null;
    }
}
