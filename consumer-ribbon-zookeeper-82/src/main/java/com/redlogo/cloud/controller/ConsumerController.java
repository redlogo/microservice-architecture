package com.redlogo.cloud.controller;

import com.redlogo.cloud.entities.CommonResult;
import com.redlogo.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Controller layer.
 *
 * @author redlogo
 * @version 0.1
 */
@RestController
@Slf4j
public class ConsumerController {
    // must be same as provide, case sensitive for zookeeper
    private static final String PROVIDER_SERVICE = "http://provider-payment-service-zookeeper";

    @Resource
    private RestTemplate restTemplate;

    @Value("${spring.cloud.zookeeper.discovery.instance-id}")
    private String instanceId;

    /**
     * Create payment.
     * There are two ways of using restTemplate: postForObject, postForEntity.
     *
     * @param payment
     * @return CommonResult to http client.
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        log.info("***** " + instanceId + " ConsumerController /consumer/payment/create invoked *****");
        return restTemplate.postForObject(PROVIDER_SERVICE + "/payment/create", payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/createForEntity")
    public CommonResult createForEntity(Payment payment) {
        log.info("***** " + instanceId + " ConsumerController /consumer/payment/createForEntity invoked *****");
        return restTemplate.postForEntity(PROVIDER_SERVICE + "/payment/create", payment, CommonResult.class).getBody();
    }

    /**
     * Get payment.
     * There are two ways of using restTemplate: postForObject, postForEntity.
     * postForEntity can get responseEntity, allows more operations.
     *
     * @param id
     * @return CommonResult to http client.
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        log.info("***** " + instanceId + " ConsumerController /consumer/payment/get/" + id + " invoked *****");
        return restTemplate.getForObject(PROVIDER_SERVICE + "/payment/get/" + id, CommonResult.class);
    }
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult getPaymentForEntity(@PathVariable("id") Long id) {
        log.info("***** " + instanceId + " ConsumerController /consumer/payment/getForEntity/" + id + " invoked *****");
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PROVIDER_SERVICE + "/payment/get/" + id, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("***** " + instanceId + " ConsumerController /consumer/payment/getForEntity/" + id + " successful *****");
            return responseEntity.getBody();
        } else {
            log.info("***** " + instanceId + " ConsumerController /consumer/payment/getForEntity/" + id + " failed *****");
            return new CommonResult<>(500, "***** " + instanceId + " ConsumerController /consumer/payment/getForEntity/" + id + " failed *****");
        }
    }
}
