package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.PayType;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.PayTypeDTO;
import ai.fl.demofoods.service.PayTypeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@RestController
@RequestMapping("/api/payType")
public class PayTypeController {
    @Autowired
    PayTypeService payTypeService;

    @GetMapping("/getAll")
    public List<?> getAll() {
        return payTypeService.getAll();
    }

    @GetMapping("/getById/{id}")
    public PayType getById(@PathVariable UUID id) {
        return payTypeService.getById(id);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody PayTypeDTO payTypeDTO) {
        ApiResponce add = payTypeService.add(payTypeDTO);
        return ResponseEntity.status(add.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(add);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody PayTypeDTO payTypeDTO) {
        ApiResponce edit = payTypeService.edit(id, payTypeDTO);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(edit);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        ApiResponce delete = payTypeService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(delete);
    }
}
