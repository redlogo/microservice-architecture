package com.redlogo.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Minimum payment pojo.
 *
 * @author redlogo
 * @version 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private Long id;
    private String serial;
}
