package com.redlogo.cloud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Spring Data JPA entity class.
 *
 * @author redlogo
 * @version 0.1
 */
// Tell Spring Boot this is a mapper to database.
@Entity
// Tell Spring Boot the table name, need to add database then assign data source in Intellij.
// By default the table name will be the default smaller case of class name.
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// solve the problem of "No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyIn"
// there is null field in database table, ignore them by using the following annotation
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "Handler"})
public class Payment {
    // primary key
    @Id
    // GenerationType.IDENTITY means autoincrement key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "ser_ial"), can map to different names
    @Column
    private String serial;
}
