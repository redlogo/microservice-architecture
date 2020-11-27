package com.redlogo.cloud.repository;

import com.redlogo.cloud.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository - DAO layer for Spring Data JPA
 *
 * @author redlogo
 * @version 0.1
 */
@Repository
// JpaRepository contains PagingAndSortingRepository which contains CrudRepository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // customized searching
    Payment findBySerial(String serial);
}
