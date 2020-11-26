package com.redlogo.cloud.service;

import com.redlogo.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Service interface.
 *
 * @author redlogo
 * @version 0.1
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
