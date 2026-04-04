package com.quantitymeasurement.measurement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

public class QuantityDTO {

    @NotNull(message = "Value cannot be null")
    private Double value;

    @NotEmpty(message = "Unit cannot be empty")
    private String unit;

    // Default constructor
    public QuantityDTO() {}

    // Parameterized constructor
    public QuantityDTO(Double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    // Getters and Setters
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}