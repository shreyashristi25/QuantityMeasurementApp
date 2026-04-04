package com.quantitymeasurement.measurement.controller;

import com.quantitymeasurement.measurement.dto.QuantityDTO;
import com.quantitymeasurement.measurement.dto.QuantityInputDTO;
import com.quantitymeasurement.measurement.service.MeasurementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    private final MeasurementService service;

    public MeasurementController(MeasurementService service) {
        this.service = service;
    }

    @PostMapping("/convert/{targetUnit}")
    public QuantityDTO convert(@RequestBody QuantityDTO input, @PathVariable String targetUnit) {
        return service.convert(input, targetUnit);
    }

    @PostMapping("/compare")
    public boolean compare(@RequestBody QuantityInputDTO input) {
        return service.compare(input.getThisQuantityDTO(), input.getThatQuantityDTO());
    }

    @PostMapping("/add")
    public QuantityDTO add(@RequestBody QuantityInputDTO input) {
        return service.add(input.getThisQuantityDTO(), input.getThatQuantityDTO());
    }

    @PostMapping("/subtract")
    public QuantityDTO subtract(@RequestBody QuantityInputDTO input) {
        return service.subtract(input.getThisQuantityDTO(), input.getThatQuantityDTO());
    }

    @PostMapping("/divide")
    public double divide(@RequestBody QuantityInputDTO input) {
        return service.divide(input.getThisQuantityDTO(), input.getThatQuantityDTO());
    }
}