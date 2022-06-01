package ai.fl.demofoods.payload;

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
public class PayTypeDTO {
    private String name;
    private UUID currencyTypeId;
}
