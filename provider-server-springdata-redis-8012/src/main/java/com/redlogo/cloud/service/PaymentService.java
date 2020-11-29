package com.redlogo.cloud.service;

import com.redlogo.cloud.entity.Payment;

/**
 * @author redlogo
 * @version 0.1
 */
public interface PaymentService {
    Payment create(Payment payment);
    Payment getPaymentById(Long id);
}
