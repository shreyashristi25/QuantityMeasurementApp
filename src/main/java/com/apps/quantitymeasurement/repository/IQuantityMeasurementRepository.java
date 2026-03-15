package com.apps.quantitymeasurement.repository;

import java.util.List;
import com.apps.quantitymeasurement.IMeasurable;
import com.apps.quantitymeasurement.model.*;

public interface IQuantityMeasurementRepository {

    void saveMeasurement(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();

}