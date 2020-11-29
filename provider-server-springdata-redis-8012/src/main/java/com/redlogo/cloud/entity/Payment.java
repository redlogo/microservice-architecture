package com.redlogo.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author redlogo
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Payment")
public class Payment implements Serializable {
    @Id
    private Long id;

    private String serial;
}
