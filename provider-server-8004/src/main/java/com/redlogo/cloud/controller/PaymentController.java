package com.redlogo.cloud.controller;

import com.redlogo.cloud.entities.CommonResult;
import com.redlogo.cloud.entities.Payment;
import com.redlogo.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller layer.
 *
 * @author redlogo
 * @version 0.1
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String instanceId;

    /**
     * Create payment.
     *
     * @param payment in http request body
     * @return CommonResult, to client
     */
    @PostMapping("/payment/create")
    public CommonResult<String> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            log.info("***** " + instanceId + " PaymentController /payment/create successful *****");
            return new CommonResult<>(200, "***** " + instanceId + " PaymentController /payment/create successful *****");
        } else {
            log.info("***** " + instanceId + " PaymentController /payment/create failed *****");
            return new CommonResult<>(500, "***** " + instanceId + " PaymentController /payment/create failed *****");
        }
    }

    /**
     * Get payment.
     *
     * @param id index id
     * @return CommonResult, to client
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            log.info("***** " + instanceId + " PaymentController /payment/get/" + id + " successful *****");
            return new CommonResult<>(200, "***** " + instanceId + " PaymentController /payment/get/" + id + " successful *****", payment);
        } else {
            log.info("***** " + instanceId + " PaymentController /payment/get/" + id + " failed *****");
            return new CommonResult<>(500, "***** " + instanceId + " PaymentController /payment/get/" + id + " failed *****");
        }
    }
}
