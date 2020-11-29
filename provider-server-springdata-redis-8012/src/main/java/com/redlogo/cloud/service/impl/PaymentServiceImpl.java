package com.redlogo.cloud.service.impl;

import com.redlogo.cloud.entity.Payment;
import com.redlogo.cloud.repository.PaymentRepository;
import com.redlogo.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author redlogo
 * @version 0.1
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).get();
    }
}
