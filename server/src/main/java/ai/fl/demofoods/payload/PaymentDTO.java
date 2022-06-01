package ai.fl.demofoods.payload;

import ai.fl.demofoods.entity.Order;
import ai.fl.demofoods.entity.PayType;
import ai.fl.demofoods.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * created by Baxromjon
 * 08.02.2022
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private UUID userId;
    private UUID payTypeId;
    private UUID orderId;
    private double amount;
    private Date payDate;
    private String description;
}
