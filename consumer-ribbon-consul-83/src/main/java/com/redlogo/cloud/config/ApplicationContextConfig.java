package com.redlogo.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Config for Ribbon + RestTemplate.
 *
 * @author redlogo
 * @version 0.1
 */
@Configuration
public class ApplicationContextConfig {
    // use bean to inject applicationContext.xml
    @Bean
    // use Ribbon, default as round robin strategy
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
