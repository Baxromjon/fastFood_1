package ai.fl.demofoods.payload;

import ai.fl.demofoods.entity.Category;
import ai.fl.demofoods.entity.ValueMeasurement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * created by Baxromjon
 * 07.02.2022
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String name;
    private String description;
    private double price;
    private Integer discountPercent;
    private UUID categoryId;
    private UUID photoId;

}
