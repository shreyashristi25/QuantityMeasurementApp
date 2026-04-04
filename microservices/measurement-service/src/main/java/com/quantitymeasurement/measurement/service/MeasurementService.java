package com.quantitymeasurement.measurement.service;


import com.quantitymeasurement.measurement.core.*;
import com.quantitymeasurement.measurement.dto.QuantityDTO;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    private Quantity<?> createQuantity(QuantityDTO dto) {
        try {
            LengthUnit unit = LengthUnit.valueOf(dto.getUnit().toUpperCase());
            return new Quantity<>(dto.getValue(), unit);
        } catch (Exception ignored) {}
        try {
            WeightUnit unit = WeightUnit.valueOf(dto.getUnit().toUpperCase());
            return new Quantity<>(dto.getValue(), unit);
        } catch (Exception ignored) {}
        try {
            VolumeUnit unit = VolumeUnit.valueOf(dto.getUnit().toUpperCase());
            return new Quantity<>(dto.getValue(), unit);
        } catch (Exception ignored) {}
        try {
            TemperatureUnit unit = TemperatureUnit.valueOf(dto.getUnit().toUpperCase());
            return new Quantity<>(dto.getValue(), unit);
        } catch (Exception ignored) {}
        throw new IllegalArgumentException("Unsupported unit: " + dto.getUnit());
    }

    public QuantityDTO convert(QuantityDTO input, String targetUnit) {
        Quantity<?> quantity = createQuantity(input);
        Object unit = quantity.getUnit();
        if (unit instanceof LengthUnit) {
            LengthUnit target = LengthUnit.valueOf(targetUnit.toUpperCase());
            Quantity<LengthUnit> converted = ((Quantity<LengthUnit>) quantity).convertTo(target);
            return new QuantityDTO(converted.getValue(), converted.getUnit().name());
        } else if (unit instanceof WeightUnit) {
            WeightUnit target = WeightUnit.valueOf(targetUnit.toUpperCase());
            Quantity<WeightUnit> converted = ((Quantity<WeightUnit>) quantity).convertTo(target);
            return new QuantityDTO(converted.getValue(), converted.getUnit().name());
        } else if (unit instanceof VolumeUnit) {
            VolumeUnit target = VolumeUnit.valueOf(targetUnit.toUpperCase());
            Quantity<VolumeUnit> converted = ((Quantity<VolumeUnit>) quantity).convertTo(target);
            return new QuantityDTO(converted.getValue(), converted.getUnit().name());
        } else if (unit instanceof TemperatureUnit) {
            TemperatureUnit target = TemperatureUnit.valueOf(targetUnit.toUpperCase());
            Quantity<TemperatureUnit> converted = ((Quantity<TemperatureUnit>) quantity).convertTo(target);
            return new QuantityDTO(converted.getValue(), converted.getUnit().name());
        }
        throw new IllegalArgumentException("Unsupported unit type");
    }

    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> qa = createQuantity(q1);
        Quantity<?> qb = createQuantity(q2);
        return qa.equals(qb);
    }

    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> qa = createQuantity(q1);
        Quantity<?> qb = createQuantity(q2);
        Quantity<?> result = ((Quantity) qa).add((Quantity) qb);
        return new QuantityDTO(result.getValue(), result.getUnit().toString());
    }

    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> qa = createQuantity(q1);
        Quantity<?> qb = createQuantity(q2);
        Quantity<?> result = ((Quantity) qa).subtract((Quantity) qb);
        return new QuantityDTO(result.getValue(), result.getUnit().toString());
    }

    public double divide(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> qa = createQuantity(q1);
        Quantity<?> qb = createQuantity(q2);
        return ((Quantity) qa).divide((Quantity) qb);
    }
}