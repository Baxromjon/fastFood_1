package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.Measurement;
import ai.fl.demofoods.repository.MeasurementRepository;
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
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public List<Measurement> getAll() {
        return measurementRepository.findAll();
    }

    public Measurement getById(UUID id) {
        Optional<Measurement> optional = measurementRepository.findById(id);
        return optional.orElseGet(Measurement::new);
    }
}
