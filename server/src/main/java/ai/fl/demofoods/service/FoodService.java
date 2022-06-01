package ai.fl.demofoods.service;

import ai.fl.demofoods.entity.Attachment;
import ai.fl.demofoods.entity.Category;
import ai.fl.demofoods.entity.Food;
import ai.fl.demofoods.entity.ValueMeasurement;
import ai.fl.demofoods.payload.ApiResponce;
import ai.fl.demofoods.payload.FoodDTO;
import ai.fl.demofoods.repository.AttachmentRepository;
import ai.fl.demofoods.repository.CategoryRepository;
import ai.fl.demofoods.repository.FoodRepository;
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
public class FoodService {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ValueMeasurementRepository valueMeasurementRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food getById(UUID id) {
        Optional<Food> optional = foodRepository.findById(id);
        return optional.orElseGet(Food::new);
    }

    public ApiResponce save(FoodDTO foodDTO) {
        Category category = categoryRepository.findById(foodDTO.getCategoryId()).orElseGet(Category::new);
//        ValueMeasurement valueMeasurement = valueMeasurementRepository.findById(foodDTO.getValueMeasurementId()).orElseGet(ValueMeasurement::new);
        Attachment attachment = attachmentRepository.findById(foodDTO.getPhotoId()).orElseGet(Attachment::new);
        Boolean exists = foodRepository.existsByNameAndCategory(foodDTO.getName(), category);
        if (exists)
            return new ApiResponce(false, "All Ready exists");
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setDescription(foodDTO.getDescription());
        food.setDiscountPercent(foodDTO.getDiscountPercent());
        if (foodDTO.getDiscountPercent() != null) {
            food.setPrice(foodDTO.getPrice() - (foodDTO.getDiscountPercent() * foodDTO.getPrice() / 100));
        }
        food.setPrice(foodDTO.getPrice());
        food.setCategory(category);
//        food.setValueMeasurement(valueMeasurement);
        food.setPhoto(attachment);
        foodRepository.save(food);
        return new ApiResponce(true, "Successfully added");
    }

    public ApiResponce edit(UUID id, FoodDTO foodDTO) {
        Category category = categoryRepository.findById(foodDTO.getCategoryId()).orElseGet(Category::new);
//        ValueMeasurement valueMeasurement = valueMeasurementRepository.findById(foodDTO.getValueMeasurementId()).orElseGet(ValueMeasurement::new);
        Optional<Food> optional = foodRepository.findById(id);
        if (!optional.isPresent())
            return new ApiResponce(false, "Food not found by given id");
        Food food = optional.get();
        food.setName(foodDTO.getName());
        food.setDescription(foodDTO.getDescription());
        food.setPrice(foodDTO.getPrice());
        food.setDiscountPercent(foodDTO.getDiscountPercent());
        food.setCategory(category);
//        food.setValueMeasurement(valueMeasurement);
        foodRepository.save(food);
        return new ApiResponce(true, "Successfully added");
    }

    public ApiResponce delete(UUID id) {
        try {
            foodRepository.deleteById(id);
            return new ApiResponce(true, "Successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ApiResponce(true, "Successfully deleted");
    }

    public List<Food> getByCategoryId(UUID id) {
        return foodRepository.getByCategoryId(id);
    }
}
