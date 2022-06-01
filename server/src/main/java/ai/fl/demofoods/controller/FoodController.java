package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.Food;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.FoodDTO;
import ai.fl.demofoods.service.FoodService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * created by Baxromjon
 * 07.02.2022
 **/

@RestController
@RequestMapping("/api/foods")
@CrossOrigin
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/getAll")
    public List<Food> getAll() {
        return foodService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Food getById(@PathVariable UUID id) {
        return foodService.getById(id);
    }

    @GetMapping("/getByCategoryId/{id}")
    public List<Food> getByCategoryId(@PathVariable UUID id){
        return foodService.getByCategoryId(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> save(@RequestBody FoodDTO foodDTO) {
        ApiResponce save = foodService.save(foodDTO);
        return ResponseEntity.status(save.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(save);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody FoodDTO foodDTO) {
        ApiResponce edit = foodService.edit(id, foodDTO);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(edit);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        ApiResponce delete = foodService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(delete);
    }
}
