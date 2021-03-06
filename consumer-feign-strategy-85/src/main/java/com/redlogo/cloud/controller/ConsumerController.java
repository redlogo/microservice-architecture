package com.redlogo.cloud.controller;

import com.redlogo.cloud.entities.CommonResult;
import com.redlogo.cloud.entities.Payment;
import com.redlogo.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author redlogo
 * @version 0.1
 */
@RestController
@Slf4j
public class ConsumerController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String paymentTimeout() {
        // By default, wait for 1s, adjustable by application.yaml
        return paymentFeignService.paymentTimeout();
    }
}
