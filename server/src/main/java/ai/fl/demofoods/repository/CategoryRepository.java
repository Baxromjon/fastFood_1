package ai.fl.demofoods.repository;

import ai.fl.demofoods.entity.Category;
import ai.fl.demofoods.entity.Food;
import ai.fl.demofoods.projection.FoodProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Boolean existsByName(String name);

    @Query(value = "select f.name as foodName, f.description as description, cast(f.photo_id as varchar) as photoId, f.price as price\n" +
            "from food f\n" +
            "where f.category_id = :categoryId", nativeQuery = true)
    List<FoodProjection> getAllFoodByCategoryId(@PathVariable UUID categoryId);
}
