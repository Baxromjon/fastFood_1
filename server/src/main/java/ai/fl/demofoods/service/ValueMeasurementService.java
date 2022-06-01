package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.ValueMeasurement;
import ai.fl.demofoods.projection.ValueMeasurementProjection;
import ai.fl.demofoods.repository.ValueMeasurementRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * created by Baxromjon
 * 07.02.2022
 **/

@Service
public class ValueMeasurementService {
    @Autowired
    ValueMeasurementRepository valueMeasurementRepository;

    public List<ValueMeasurement> getAll() {
        return valueMeasurementRepository.findAll();
    }

    public ValueMeasurement getById(UUID id) {
        Optional<ValueMeasurement> optional = valueMeasurementRepository.findById(id);
        return optional.orElseGet(ValueMeasurement::new);
    }

    public List<ValueMeasurementProjection> getByMeasurementId(UUID measurementId) {
        return valueMeasurementRepository.getByMeasurementId(measurementId);
    }
}
