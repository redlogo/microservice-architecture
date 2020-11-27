package com.redlogo.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.redlogo.cloud.entities.CommonResult;
import com.redlogo.cloud.entities.Payment;
import com.redlogo.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Controller layer Hystrix.
 *
 * @author redlogo
 * @version 0.1
 */
@RestController
@Slf4j
// default Hystrix fallback
@DefaultProperties(defaultFallback = "paymentHystrixDefaultFallback") // default fallback
public class ConsumerController {
    @Resource
    private PaymentFeignService paymentFeignService;

    // use default fallback
    @HystrixCommand
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        // default fallback paymentHystrixDefaultFallback() is not triggered, because the return of provider is a successful CommonResult<Payment>, although it contains error information.
        return paymentFeignService.getPaymentById(id);
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHystrixFallbackHandler", commandProperties = { // if failure, use paymentInfo_TIMEOUT_handler_consumer
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") // time out
    })
    @GetMapping("/consumer/payment/timeout/hystrix-fallback")
    public String paymentTimeoutHystrixFallback() {
        return paymentFeignService.paymentTimeoutHystrixFallback();
    }
    public String paymentTimeoutHystrixFallbackHandler() {
        return Thread.currentThread().getName() + " paymentTimeoutHystrixFallback() failed, callback paymentTimeoutHystrixFallbackHandler()";
    }

    public CommonResult<Payment> paymentHystrixDefaultFallback() {
        return new CommonResult<>(500, "Request failed. This is a default callback.", new Payment(-1L, "paymentHystrixDefaultFallback() triggered"));
    }
}
