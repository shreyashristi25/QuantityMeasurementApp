package com.quantitymeasurement.measurement.dto;

import lombok.Data;

@Data
public class QuantityInputDTO {
	private QuantityDTO thisQuantityDTO;
	private QuantityDTO thatQuantityDTO;
}