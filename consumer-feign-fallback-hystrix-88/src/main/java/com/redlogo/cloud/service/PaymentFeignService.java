package com.redlogo.cloud.service;

import com.redlogo.cloud.entities.CommonResult;
import com.redlogo.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign service, key component to use Feign.
 *
 * @author redlogo
 * @version 0.1
 */
@Component
// Feign links to this service
// Feign fallback
@FeignClient(value = "PROVIDER-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFeignFallbackService.class)
public interface PaymentFeignService {
    // directly mapping methods from the controller layer of PROVIDER-PAYMENT-SERVICE
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping("/payment/timeout/hystrix-fallback")
    String paymentTimeoutHystrixFallback();
}
