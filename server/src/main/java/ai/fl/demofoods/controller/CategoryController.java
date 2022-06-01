package ai.fl.demofoods.controller;

import ai.fl.demofoods.entity.Category;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.CategoryDTO;
import ai.fl.demofoods.service.CategoryService;
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
 * 04.02.2022
 **/


@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/allCategory")
    public HttpEntity<?> getAllCategory() {
        List<Category> allCategory = categoryService.getAllCategory();
        return ResponseEntity.ok(allCategory);
    }

    @PostMapping("/addCategory")
    public HttpEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) {
        ApiResponce apiResponce = categoryService.addCategory(categoryDTO);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> editCategory(@PathVariable UUID id, @RequestBody CategoryDTO categoryDTO) {
        ApiResponce apiResponce = categoryService.editCategory(id, categoryDTO);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getById/{id}")
    public Category getById(@PathVariable UUID id) {
        return categoryService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteCategory(@PathVariable UUID id) {
        ApiResponce apiResponce = categoryService.deleteCategory(id);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getByCategoryId/{categoryId}")
    public ApiResponce getAllFoodByCategoryId(@PathVariable UUID categoryId) {
        return categoryService.getAllFoodsByCategoryId(categoryId);
    }
}
