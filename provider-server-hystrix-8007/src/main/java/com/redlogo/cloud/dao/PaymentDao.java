package com.redlogo.cloud.dao;

import com.redlogo.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Payment DAO layer.
 *
 * @author redlogo
 * @version 0.1
 */
// @Mapper is better than @Repository which sometimes has problems
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
