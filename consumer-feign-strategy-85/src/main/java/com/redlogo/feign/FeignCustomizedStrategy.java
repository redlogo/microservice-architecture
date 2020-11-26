package com.redlogo.feign;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign (Ribbon) load balancing strategy.
 * Use different package to avoid mixing up with other strategies
 *
 * @author redlogo
 * @version 0.1
 */
@Configuration
public class FeignCustomizedStrategy {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
