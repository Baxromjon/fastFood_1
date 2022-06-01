package ai.fl.demofoods.payload;

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
public class DrinksDTO {
    private String name;
    private String description;
    private double price;
    private UUID valueId;
    private UUID photoId;
}
