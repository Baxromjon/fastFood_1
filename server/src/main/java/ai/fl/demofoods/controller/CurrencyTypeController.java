package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.CurrencyType;
import ai.fl.demofoods.entity.PayType;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.CurrencyTypeDTO;
import ai.fl.demofoods.service.CurrencyTypeService;
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
@RequestMapping("/api/currencyType")
public class CurrencyTypeController {
    @Autowired
    CurrencyTypeService currencyTypeService;

    @GetMapping("/getAll")
    public List<?> getAll() {
        return currencyTypeService.getAll();
    }

    @GetMapping("/getById/{id}")
    public CurrencyType getById(@PathVariable UUID id) {
        return currencyTypeService.getById(id);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody CurrencyTypeDTO currencyTypeDTO) {
        ApiResponce add = currencyTypeService.add(currencyTypeDTO);
        return ResponseEntity.status(add.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(add);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody CurrencyTypeDTO currencyTypeDTO) {
        ApiResponce edit = currencyTypeService.edit(id, currencyTypeDTO);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(edit);
    }
}
