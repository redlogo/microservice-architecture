package com.redlogo.cloud.service;

import com.redlogo.cloud.entities.CommonResult;
import com.redlogo.cloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author redlogo
 * @version 0.1
 */
@Component
public class PaymentFeignFallbackService implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(500, "Feign fallback getPaymentById() ", new Payment(-1L, "Feign fallback"));
    }

    @Override
    public String paymentTimeoutHystrixFallback() {
        return Thread.currentThread().getName() + " Feign fallback paymentTimeoutHystrixFallback()";
    }
}
