package com.redlogo.cloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.redlogo.cloud.dao.PaymentDao;
import com.redlogo.cloud.entities.Payment;
import com.redlogo.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service layer implementation.
 * Service layer Hystrix operations.
 * Fallback must have same input and output as the method which callback it.
 *
 * @author redlogo
 * @version 0.1
 */
@Service
// default Hystrix fallback, work with @HystrixCommand
@DefaultProperties(defaultFallback = "defaultHystrixFallbackHandler")
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    @HystrixCommand
    public Payment getPaymentById(Long id) {
        int a = 100 / 0;
        return paymentDao.getPaymentById(id);
    }

    // provider side hystrix fall back, 1 method mapping to 1 fallback method
    // time out limit: 1s
    @HystrixCommand(fallbackMethod = "paymentTimeoutHystrixFallbackHandler",
                    commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"))
    @Override
    public String paymentTimeoutHystrixFallback() {
        // runtime error way to trigger fallback
        // int a = 100 / 0;
        // time out way to trigger fallback
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
        return Thread.currentThread().getName() + " paymentTimeoutHystrixFallback() successful, don't need callback method";
    }
    public String paymentTimeoutHystrixFallbackHandler() {
        return Thread.currentThread().getName() + " paymentTimeoutHystrixFallback() failed, callback paymentTimeoutHystrixFallbackHandler()";
    }

    // circuit breaker / fuse
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallbackHandler",
                    commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // enable circuit breaker
                                         @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 10 times of requests
                                         @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // in 10 seconds
                                         @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")}) // if failure more than 60%
    @Override
    public String paymentCircuitBreakerFallback(Long id) {
        if (id < 0) throw new RuntimeException("paymentCircuitBreakerFallback() error triggered");
        return Thread.currentThread().getName() + " paymentCircuitBreakerFallback() successful, input id: " + id;
    }
    public String paymentCircuitBreakerFallbackHandler(Long id) {
        return Thread.currentThread().getName() + " paymentCircuitBreakerFallback() failed, callback paymentCircuitBreakerFallbackHandler(Long id), id: " + id;
    }

    public Payment defaultHystrixFallbackHandler() {
        log.info(Thread.currentThread().getName() + " some method failed, callback defaultHystrixFallbackHandler()");
        return new Payment(-1L, Thread.currentThread().getName() + " some method failed, callback defaultHystrixFallbackHandler()");
    }
}
