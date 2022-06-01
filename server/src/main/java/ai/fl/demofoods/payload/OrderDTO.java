package ai.fl.demofoods.payload;

import ai.fl.demofoods.entity.Drinks;
import ai.fl.demofoods.entity.Food;
import ai.fl.demofoods.entity.User;
import ai.fl.demofoods.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private UUID foodId;
    private UUID drinksId;
    private UUID userId;
    private double totalPrice;
}
