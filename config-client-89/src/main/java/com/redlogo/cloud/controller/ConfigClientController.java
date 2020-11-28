package com.redlogo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author redlogo
 * @version 0.1
 */
@RestController
// Can accept dynamic post changes: curl -X POST "http://localhost:89/actuator/refresh" which is done by DevOps.
// This is 1 by 1 method.
// For better notification methodology, use Spring Cloud Bus.
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
