package com.redlogo.cloud.controller;

import com.redlogo.cloud.entities.CommonResult;
import com.redlogo.cloud.entity.Payment;
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

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    /**
     * Create payment.
     *
     * @param payment in http request body
     * @return CommonResult, to client
     */
    @PostMapping("/payment/create")
    public CommonResult<String> create(@RequestBody Payment payment) {
        Payment res = paymentService.create(payment);
        log.info("***** " + instanceId + " PaymentController /payment/create finished *****");
        log.info("***** returned result: " + res.toString());
        return new CommonResult<>(200, "***** " + instanceId + " PaymentController /payment/create finished *****");
    }

    /**
     * Get payment.
     *
     * @param id index id
     * @return CommonResult, to client
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment res = paymentService.getPaymentById(id);
        if (res != null) {
            log.info("***** " + instanceId + " PaymentController /payment/get/" + id + " successful *****");
            log.info("***** returned result: " + res.toString());
            return new CommonResult<>(200, "***** " + instanceId + " PaymentController /payment/get/" + id + " successful *****", res);
        } else {
            log.info("***** " + instanceId + " PaymentController /payment/get/" + id + " failed *****");
            return new CommonResult<>(500, "***** " + instanceId + " PaymentController /payment/get/" + id + " failed *****");
        }
    }
}
