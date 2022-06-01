package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.Category;
import ai.fl.demofoods.entity.Food;
import ai.fl.demofoods.entity.ValueMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FoodRepository extends JpaRepository<Food, UUID> {
    Boolean existsByNameAndCategory(String name, Category category);

    @Query(nativeQuery = true, value = "select * from food\n" +
            "where category_id=:id")
    List<Food> getByCategoryId(UUID id);
}
