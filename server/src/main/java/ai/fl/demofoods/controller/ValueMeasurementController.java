package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.ValueMeasurement;
import ai.fl.demofoods.projection.ValueMeasurementProjection;
import ai.fl.demofoods.service.ValueMeasurementService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * created by Baxromjon
 * 07.02.2022
 **/

@RestController
@RequestMapping("/api/value")
@CrossOrigin
public class ValueMeasurementController {
    @Autowired
    ValueMeasurementService valueMeasurementService;

    @GetMapping("/getAll")
    public List<ValueMeasurement> getAll(){
        return valueMeasurementService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ValueMeasurement getById(@PathVariable UUID id){
        return valueMeasurementService.getById(id);
    }

    @GetMapping("/getByMeasurementId/{measurementId}")
    public List<ValueMeasurementProjection> getByMeasurementId(@PathVariable UUID measurementId){
       return valueMeasurementService.getByMeasurementId(measurementId);
    }
}
