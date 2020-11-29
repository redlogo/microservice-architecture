package com.redlogo.cloud.repository;

import com.redlogo.cloud.entity.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author redlogo
 * @version 0.1
 */
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
