
package com.app.quantitymeasurement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="quantity_measurements")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private java.time.LocalDateTime timestamp;

    private String operation;
    private String operand1;
    private String operand2;
    private String result;
    private String errorMessage;


}