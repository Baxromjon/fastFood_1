package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.Category;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.CategoryDTO;
import ai.fl.demofoods.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public ApiResponce addCategory(CategoryDTO categoryDTO) {
        Boolean exists = categoryRepository.existsByName(categoryDTO.getName());
        if (exists)
            return new ApiResponce(false, "Category allReady exists");
        Category category = new Category(
                categoryDTO.getName(),
                categoryDTO.getDescription()
        );
        categoryRepository.save(category);
        return new ApiResponce(true, "Category successfully saved");
    }

    public ApiResponce editCategory(UUID id, CategoryDTO categoryDTO) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (!optional.isPresent())
            return new ApiResponce(false, "Category not found by given Id");
        Category category = optional.get();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        categoryRepository.save(category);
        return new ApiResponce(true, "Category successfully edited");
    }

    public Category getById(UUID id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.get();
    }

    public ApiResponce deleteCategory(UUID id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponce(false, "Category not found by given id");
        }
        try {
            categoryRepository.deleteById(id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ApiResponce(true, "Successfully deleted");
    }

    public ApiResponce getAllFoodsByCategoryId(UUID categoryId) {
        return new ApiResponce(true, categoryRepository.getAllFoodByCategoryId(categoryId));
    }
}
