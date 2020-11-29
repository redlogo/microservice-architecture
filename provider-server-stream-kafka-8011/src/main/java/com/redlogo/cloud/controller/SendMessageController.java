package com.redlogo.cloud.controller;

import com.redlogo.cloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Send message API.
 *
 * @author redlogo
 * @version 0.1
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
