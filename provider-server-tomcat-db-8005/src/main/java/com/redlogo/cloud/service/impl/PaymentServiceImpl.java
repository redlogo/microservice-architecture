package com.redlogo.cloud.service.impl;

import com.redlogo.cloud.dao.PaymentDao;
import com.redlogo.cloud.entities.Payment;
import com.redlogo.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service layer implementation.
 *
 * @author redlogo
 * @version 0.1
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
