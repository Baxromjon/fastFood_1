package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.Drinks;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.DrinksDTO;
import ai.fl.demofoods.service.DrinksService;
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
@RequestMapping("/api/drinks")
@CrossOrigin
public class DrinksController {
    @Autowired
    DrinksService drinksService;

    @GetMapping("/getAll")
    public List<Drinks> getAll() {
        return drinksService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Drinks getById(@PathVariable UUID id) {
        return drinksService.getById(id);
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> save(@RequestBody DrinksDTO drinksDTO) {
        ApiResponce save = drinksService.save(drinksDTO);
        return ResponseEntity.status(save.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(save);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody DrinksDTO drinksDTO) {
        ApiResponce edit = drinksService.edit(id, drinksDTO);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(edit);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        ApiResponce delete = drinksService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(delete);
    }
}
