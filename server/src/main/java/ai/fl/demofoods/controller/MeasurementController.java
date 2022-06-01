package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.Measurement;
import ai.fl.demofoods.service.MeasurementService;
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
@RequestMapping("/api/measurement")
@CrossOrigin
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    @GetMapping("/getAll")
    public List<Measurement> getAll(){
       return measurementService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Measurement getById(@PathVariable UUID id){
        return measurementService.getById(id);
    }
}
