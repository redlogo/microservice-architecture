package com.redlogo.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * A provider (payment) microservice.
 * Use Netflix Eureka, Hystrix.
 *
 * @author redlogo
 * @version 0.1
 */
@SpringBootApplication
// for Eureka
@EnableEurekaClient
// enable Hystrix circuit breaker
@EnableCircuitBreaker
public class ProviderHystrix8007 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrix8007.class, args);
    }

    // injection of hystrix servlet, must be here
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
